# Expression Language FAQ

1. Welche anderen Formen/Version einer Expression Language gibt es im JEE-Kontext? Warum gibt es diese?
Was sind die zentralen Unterschiede?

| Form/Edition | Release  | Eigenschaften                     |
|:------------:|:--------:|-----------------------------------|
| EL JSTL 1.0 |Jun 2002 | Einführung der Immediate Syntax ${} welche nur in JSTL Tags verwendet werden kann und wobei nur das Referenzieren von Gettern unterstützt wird.|
| EL JSP 2.0 (Standard EL) | Nov 2003  | Die EL wurde nun von JSTL 1.0 nach JSP 2.0 ([javax.servlet.jsp.el](http://docs.oracle.com/javaee/5/api/javax/servlet/jsp/el/package-summary.html)) verschoben und ${} lässt sich nun außerhalb von JSTL Tags in JSP Templates verwenden.|
| EL JSF 1.0 | Mar 2004 | Einführung der Deferred EL #{} in JSF 1.0 ([javax.faces.el](http://docs.oracle.com/javaee/5/api/javax/faces/el/package-summary.html)). Im Gegensatz zur ${} Syntax unterstüzt die #{} Syntax auch das Referenzieren von Settern und die Bean Auto-Creation.|
| EL JSF 1.2 (Unified EL) | May 2005 | Deferred EL wurde von JSF extrahiert und mit der Standard EL in dem Package [javax.el](http://docs.oracle.com/javaee/5/api/javax/el/package-summary.html) zusammengefasst und wurde später Bestandteil von JSP 2.1 und Java EE 5.|
| EL Facelets | Nov 2006 | Eingeführt als Nachfolger von JSP. Es erlaubt die Verwendung von #{} in Template-Text Außerhalb JSF-Tags, als Ersatz für &lt;h:outputText&gt;. Weiterhin sind ${}, #{} innerhalb von Facelets äquivalent zueinander.|
| El 2.2 (JSR-245) | Dec 2009/2013 | EL wurde in eine Standalone Specification ([JSR-245](https://jcp.org/en/jsr/detail?id=245)) extrahiert. EL unterstützt nun parametrisierte Methoden Aufrufe und ist nun Bestandteil von Java EE 6. Und ist die Basis für JSF EL 2.2|
| EL 3.0 | Jun 2013 | EL besitzt nun einen Standalone EL-Prozessor, mit der Intention die EL innerhalb von Java SE Anwendungen verwenden zu können. An Bord sind der neue String Concatenations Operator += und die Unterstützung von Java Lambda Ausdrücken. |

Die Versionen unterscheiden sich im Funktionsumfang, dem Ausführungs-Context und dem Verwendungszweck.
Die Gründe für die unterschiedlichen Varianten sind historisch bedingt siehe Tabelle.

- [Stackoverflow.com difference-between-jsp-el-jsf-el-and-unified-el (01.01.2016)](http://stackoverflow.com/questions/4812755/difference-between-jsp-el-jsf-el-and-unified-el)
- [The Java EE 6 Tutorial Chapter 6 Expression Language (01.01.2016)](http://docs.oracle.com/javaee/6/tutorial/doc/gjddd.html)

2. Bei der Abarbeitung eines Facelets: Wo und in welcher Reihenfolge wird beim
Ausdruck <h:outputText value="#{ myBean.myBeanProperty }" .../> nach dem Objekt myBean gesucht?

Laut der JSF 2.2 Spezifikation wird über _FacesContext.getCurrentInstance().getELContext().ELResolver() ein _[ELResolver](https://docs.oracle.com/javaee/7/api/javax/el/ELResolver.html)_ bezogen wird.
Ein ELResolver ist dafür verantwortlich ein EL Segment auszuwerten. Segmente sind die durch einen Punkt getrennten Strings bzw.
der gesamte Ausdruck wird als Segment angesehen, sofern keine Punkte im Ausdruck enthalten sind.

Die Spezifikation beschreibt die Implementierung des ELResolver für die Auswertung von EL-Ausdrücken als
eine Art Chain-of-responsibility:

    During the course of evaluation of an
    expression, a variety of sources must be considered to help resolve each segment of the expression. These sources are
    linked in a chain-like fashion. Each link in the chain has the opportunity to resolve the current segment. If it does so, it
    must set the “propertyResolved” property on the ELContext, to true. If not, it must not modify the value of the
    “propertyResolved” property. If the “propertyResolved” property is not set to true the return value from the
    ELResolver method is ignored by the system.

Somit wird mittels der Chain-of-responsibility ein passender ELResolver gesucht,
zum Beispiel einem ManagedBeanELResolver und im Anschluss kann über diesen die entsprechende Instanz bezogen werden.

[JSR-000344 JavaServerTM Faces 2.2 Final Release](http://download.oracle.com/otndocs/jcp/jsf-2_2-fr-eval-spec/index.html)

3. In einem Facelet: Wann sollte man #{myBean.myBeanProperty} und wann
<h:outputText value="#{ myBean.myBeanProperty }" .../> verwenden?

Die Syntax #{myBean.myBeanProperty} verwendet man nur sofern man nur die Ausgabe
eines BeanProperties wünscht. Wird ein Converter benötigt oder soll das Tag
in einem Template referenziert werden können, so verwendet man die
Syntax: <h:outputText value="#{ myBean.myBeanProperty }" .../>.

4. Was passiert bei der Abarbeitung von #{var.p1.p2.p3}?

Wie bereits im Punkt 2. beschrieben wird jedes Segement über den ELResolver
ausgewertet.

5. Welche drei unterschiedlichen Zwecke kann ein Ausdruck der Form #{...} (zwischen
   den Klammern steht ein beliebiger EL-Ausdruck) in einem Faclet mit JSF EL 2.0
   erfüllen ?

   * Referenzieren von Gettern/Settern
   * Referenzieren von Action/ActionListeners
   * Auruf von Methoden um Werte berechnen zu lassen
   * Auswerten von logischen und arithmetischen Ausdrücken

6. Was sind implizite Objekte? Welche stellt die EL zur Verfügung?

Sind Objekte die durch den Ausführungs-Context bzw. in unserem Fall dem JSF bereit gestellt werden.
Diese vordefinierten Objekte bieten Zugriff auf relevante Informationen wie Sessions, View usw.

* application	    This provides user access to the ApplicationContext implementation of ServletContext that represents a web application's execution environment.
* applicationScope	Maps application-scoped variable names to their values.
* cc	            Implicit EL object that provides access to the JSF Composite Component. cc refers to the top level composite component processed at the time of evaluation
* component	        Implicit EL object representing javax.faces.component.UIComponentfor the current component.
* cookie	        Maps a cookie name to a single cookie.
* facesContext	    The FacesContext instance for the current request.
* flash	            Provides user access to the EL implicit javax.faces.context.Flash object. It may additional obtained via #{facesContext.externalContext.flash}. The implementation must ensure that the flash is usable from both JSP and from Facelets for JSF 2.
* header	        Maps a request header name to a single value.
* headerValues	    Maps a request header name to an array of values.
* initParam	        Maps a context initialization parameter name to a single value.
* param	            Maps a request parameter name to a single value.
* paramValues	    Maps a request parameter name to an array of values.
* request	        EL implicit object for current request.
* requestScope	    Maps request-scoped variable names to their values.
* resource	        EL implicit object for javax.faces.application.ResourceHandler.
* session	        Provides EL access to the current HttpSession object.
* sessionScope	    Maps session-scoped variable names to their values.
* view	            Provides access to the javax.faces.component.UIViewRoot for the current instance.
* viewScope	        Maps view-scoped variable names to their values.


7. Welches Problem kann sich aus der Verwendung von impliziten Objekten (in Facelets)
   ergeben?

Da diese Namen bereits vergeben sind und der ImplicitObjectELResolver eine
höhere Priorität als anderere ELResolver besitzt können ManagedBeans mit
gleichen Namen wie die der Implizit Objekte nicht über EL referenziert werden.

8. Welche 4 Typen von Operatoren stellt die EL zur Verfügung?

* Arithmetic: +, - (binary), *, / and div, % and mod, - (unary)
* Logical: and, &&, or, ||, not, !
* Relational: ==, eq, !=, ne, <, lt, >, gt, <=, ge, >=, le. Comparisons can be made against other values or against Boolean, string, integer, or floating-point literals.
* Empty: The empty operator is a prefix operation that can be used to determine whether a value is null or empty.
* Conditional: A ? B : C. Evaluate B or C, depending on the result of the evaluation of A.

9. Welches Problem kann sich aus der Verwendung von EL-Operatoren ergeben?j)
   Mit der Version 2.2 können Methodenaufrufe verwendet werden, die vorher nicht
   erlaubt waren. Was ist ab dieser Version möglich? Wie beurteilen Sie diese neuen
   Möglichkeiten?

Die Logik wird zu sehr in die View verlagert. Ab Version 2.2 können Methodenaufrufe parametrisiert werden.
Die View wird nun mit mehr Logik ausgestattet, dies bietet mehr flexibilität birgt auch die Gefahr das Logik und View
zu sehr vermischt werden.

10. Was sind die technischen Voraussetzungen für den Einsatz der erweiterten
   Möglichkeiten? Können sie direkt im Tomcat 7 verwendet werden?

   Es wird lediglich eine entsprechende Jar benötigt, die diese erweiterten
   Möglichkeiten implementiert. Wie zum Beispiel 
