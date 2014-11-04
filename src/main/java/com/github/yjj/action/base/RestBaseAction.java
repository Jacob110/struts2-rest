package com.github.yjj.action.base;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ValidationAwareSupport;

@ParentPackage("rest-package")
public abstract class RestBaseAction extends ValidationAwareSupport implements
		ModelDriven<Object> {

	private static final long serialVersionUID = -8773131281804917145L;

	public abstract Object getModel();

}
