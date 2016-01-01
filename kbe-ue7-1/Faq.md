# Expression Language FAQ

1. Welche anderen Formen/Version einer Expression Language gibt es im JEE-Kontext? Warum gibt es diese?
Was sind die zentralen Unterschiede?

| Form/Edition | Release  | Eigenschaften                     |
|:------------:|:--------:|-----------------------------------|
| EL JSTL 1.0 |Jun 2002 | Einführung der Immediate Syntax ${} welche nur in JSTL Tags verwendet werden kann und wobei nur das Referenzieren von Gettern unterstützt wird.|
| EL JSP 2.0 (Standard EL) | Nov 2003  | Die EL wurde nun von JSTL 1.0 nach JSP 2.0 ([javax.servlet.jsp.el](http://docs.oracle.com/javaee/5/api/javax/servlet/jsp/el/package-summary.html)) verschoben und ${} lässt sich nun außerhalb von JSTL Tags in JSP Templates verwenden.|
| EL JSF 1.0 | Mar 2004 | Einführung der Deferred EL #{} in JSF 1.0 ([javax.faces.el](http://docs.oracle.com/javaee/5/api/javax/faces/el/package-summary.html)). Im Gegensatz zur ${} Syntax unterstüzt die #{} Syntax auch das Referenzieren von Settern und die Bean Auto-Creation.|
| EL JSF 1.2 (Unified EL) | May 2005 | Deferred EL wurde von JSF extrahiert und mit der Standard EL in dem Package [javax.el](http://docs.oracle.com/javaee/5/api/javax/el/package-summary.html) zusammengefasst und wurde später Bestandteil von JSP 2.1 und Java EE 5.|
| EL Facelets | Nov 2006 | Eingeführt als Nachfolger von JSP. Es erlaubt die Verwendung von #{} in Template-Text Außerhalb JSF-Tags, als Ersatz für <h:outputText>. Weiterhin sind ${}, #{} innerhalb von Facelets äquivalent zueinander.|
| El 2.2 (JSR-245) | Dec 2009 | EL wurde in eine Standalone Specification ([JSR-245](https://jcp.org/en/jsr/detail?id=245)) extrahiert. EL unterstützt nun parametrisierte Methoden Aufrufe und ist nun Bestandteil von Java EE 6.|
| EL 3.0 | Jun 2013 | EL besitzt nun einen Standalone EL-Prozessor, mit der Intention die EL innerhalb von Java SE Anwendungen verwenden zu können. An Bord sind der neue String Concatenations Operator += und die Unterstützung von Java Lambda Ausdrücken. |

Die Versionen unterscheiden sich im Funktionsumfang, dem Ausführungs-Context und dem Verwendungszweck.
Die Gründe für die unterschiedlichen Varianten sind historisch bedingt siehe Tabelle.

- [Stackoverflow.com difference-between-jsp-el-jsf-el-and-unified-el (01.01.2016)](http://stackoverflow.com/questions/4812755/difference-between-jsp-el-jsf-el-and-unified-el)
- [The Java EE 6 Tutorial Chapter 6 Expression Language (01.01.2016)](http://docs.oracle.com/javaee/6/tutorial/doc/gjddd.html)

2. Bei der Abarbeitung eines Facelets: Wo und in welcher Reihenfolge wird beim
Ausdruck <h:outputText value="#{ myBean.myBeanProperty }" .../> nach dem Objekt myBean gesucht?

3. In einem Facelet: Wann sollte man #{myBean.myBeanProperty} und wann
<h:outputText value="#{ myBean.myBeanProperty }" .../> verwenden?

4. Was passiert bei der Abarbeitung von #{var.p1.p2.p3}?

5. Welche drei unterschiedlichen Zwecke kann ein Ausdruck der Form #{...} (zwischen
   den Klammern steht ein beliebiger EL-Ausdruck) in einem Faclet mit JSF EL 2.0
   erfüllen?

6. Was sind implizite Objekte? Welche stellt die EL zur Verfügung?

7. Welches Problem kann sich aus der Verwendung von impliziten Objekten (in Facelets)
   ergeben?

8. Welche 4 Typen von Operatoren stellt die EL zur Verfügung?

9. Welches Problem kann sich aus der Verwendung von EL-Operatoren ergeben?j)
   Mit der Version 2.2 können Methodenaufrufe verwendet werden, die vorher nicht
   erlaubt waren. Was ist ab dieser Version möglich? Wie beurteilen Sie diese neuen
   Möglichkeiten?

10. Was sind die technischen Voraussetzungen für den Einsatz der erweiterten
   Möglichkeiten? Können sie direkt im Tomcat 7 verwendet werden?
