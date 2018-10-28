package com.watchers.business.finder.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.watchers.business.finder.model.FinderVo;
import com.watchers.business.finder.service.FinderService;
import com.watchers.common.file.util.FileDownloadUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/")
public class FinderController {
	Logger logger = LoggerFactory.getLogger(FinderController.class);
	
	@Autowired
	FinderService finderService;
	
	@RequestMapping(value = "Finder.watchers", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView goFinder(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/finder_list");
		
		mav.addObject("FinderList", finderService.getFinderList());
		
		return mav;
	}
	
	@RequestMapping(value = "FileDown.action", method = {RequestMethod.GET,RequestMethod.POST})
	public void goFileDown(HttpServletRequest request, HttpServletResponse response){
		FileDownloadUtil.download(response, request.getParameter("file_name"));
	}
	
	@RequestMapping(value = "FinderModify.action", method = RequestMethod.POST)
	public JSONObject procFinderModify(HttpServletRequest request, HttpServletResponse response, FinderVo finderInfo){
		return finderService.procFinderModify(finderInfo);
	}
	
}
