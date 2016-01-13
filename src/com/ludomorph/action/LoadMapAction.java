package com.ludomorph.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



public class LoadMapAction extends Action{

	public LoadMapAction() {
		public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
				final HttpServletResponse res) {
			final int id = Integer.parseInt(req.getParameter("id"));

			@SuppressWarnings("unchecked")
			final Map<String, Integer> map = (HashMap<String, Integer>) req.getSession().getAttribute(
					SessionConstantNames.FISHLIST);

			final IAquariumService aqua = AquariumService.getInstance();
			final IPoissonService fishService = PoissonService.getInstance();
			final List<PoissonVO> list = fishService.getListOfFish();
			final String fish = list.get(id).getEspece();
			aqua.addFish(fish, map);

			req.getSession().setAttribute(SessionConstantNames.FISHLIST, map);
			req.getSession().setAttribute(SessionConstantNames.FISHCOUNT, aqua.getNumberOfFish(map));

			return mapping.findForward("success");
		}

	}

}
