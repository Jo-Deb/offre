package com.sfeir.labs.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.user.client.ui.IsWidget;

public interface CategoryDisplay extends IsWidget, HasSelectionHandlers<String> {

	void set_E_DataToDisplay(ArrayList<ArrayList<String>> data);
	
}
