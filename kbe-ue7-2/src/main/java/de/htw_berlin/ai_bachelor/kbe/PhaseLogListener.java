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

	private class Statistics {

		public String id = "";
		public int count = 0;
		public Map<String, Integer> countsPerFamily = new HashMap<>();

		public String writeStatistics(StringBuilder info, PhaseId phaseId) {

			info.append("RootViewId: ").append(id)
				.append("\n")
				.append("Count of Views: ").append(count)
				.append("\n");

			if (phaseId == PhaseId.RENDER_RESPONSE) {

				String countsPerFamilyText = this.countsPerFamily.entrySet().stream()
					.map(entry -> entry.getKey() + ": " + entry.getValue())
					.collect(Collectors.joining("\n"));

				info.append("\nElement Count Per Family: \n")
					.append(countsPerFamilyText)
					.append("\n");
			}

			return info.toString();
		}
	}


	private static final long serialVersionUID = -6558923342427686701L;

	private final Logger log = Logger.getLogger(PhaseLogListener.class.getName());

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext facesCtx = event.getFacesContext();
		PhaseId phaseId = event.getPhaseId();
		StringBuilder detailInfo = new StringBuilder();


		if (phaseId == PhaseId.RESTORE_VIEW || phaseId== PhaseId.RENDER_RESPONSE) {

			detailInfo.append("\n");
			if (phaseId == PhaseId.RESTORE_VIEW) {
				detailInfo
					.append("Postback Request: " + facesCtx.isPostback())
					.append("\n");
			}

			UIViewRoot rootView = facesCtx.getViewRoot();
			Statistics stats = evaluateStatistics(rootView, phaseId);
			stats.writeStatistics(detailInfo, phaseId);
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

	private Statistics evaluateStatistics(UIComponent view, PhaseId phaseId) {
		Statistics statistics = new Statistics();
		statistics.id = view.getId();
		evaluateStatistics(view, statistics);
		return statistics;
	}

	private void evaluateStatistics(UIComponent view, Statistics statistics) {
		String family = view.getFamily();
		Integer count = statistics.countsPerFamily.getOrDefault(family, 0);

		statistics.countsPerFamily.put(family, count + 1);
		statistics.count++;

		view.getChildren().forEach(v -> evaluateStatistics(v, statistics));
	}

}
