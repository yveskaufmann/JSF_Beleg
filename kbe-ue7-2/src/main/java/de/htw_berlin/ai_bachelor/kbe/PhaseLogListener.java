package de.htw_berlin.ai_bachelor.kbe;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PhaseLogListener implements PhaseListener {

	private final Logger log = Logger.getLogger(PhaseLogListener.class.getName());

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext fctx = event.getFacesContext();
		PhaseId phaseId = event.getPhaseId();
		StringBuilder detailInfo = new StringBuilder();


		if (phaseId == PhaseId.RESTORE_VIEW || phaseId== PhaseId.RENDER_RESPONSE) {
			detailInfo.append("\n");
			if (phaseId == PhaseId.RESTORE_VIEW) {
				detailInfo
					.append("Postback Request: " + fctx.isPostback())
					.append("\n");
			}

			detailInfo
				.append("RootViewId: " + fctx.getViewRoot().getId())
				.append("\n")
				.append("Count of Views: " + fctx.getViewRoot().getChildCount())
				.append("\n");

			if (phaseId == PhaseId.RENDER_RESPONSE) {
				detailInfo
					.append("\nElement Count Per Family: \n")
					.append(countElementsPerFamily(fctx.getViewRoot()))
					.append("\n");
			}
		}

		log.log(Level.INFO, "End of phase: " + phaseId.getName() + detailInfo.toString());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		log.log(Level.INFO, "\nStart of phase: " + event.getPhaseId().getName());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	private String countElementsPerFamily(UIViewRoot viewRoot) {
		Map<String, Integer> elementCountPerFamily = new HashMap<>();

		countElementsPerFamily(viewRoot, elementCountPerFamily);

		return elementCountPerFamily
			.entrySet().stream()
			.map(entry -> entry.getKey() + ": " + entry.getValue())
			.collect(Collectors.joining("\n"));
	}

	private void countElementsPerFamily(UIComponent view, Map<String, Integer> elementCountPerFamily) {

		String family = view.getFamily();
		Integer count = elementCountPerFamily.getOrDefault(family, 0);

		elementCountPerFamily.put(family, count + 1);

		view.getChildren().forEach(v -> countElementsPerFamily(v, elementCountPerFamily));
	}


}
