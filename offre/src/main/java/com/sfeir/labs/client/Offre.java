package com.sfeir.labs.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.corechart.CoreChart;
import com.sfeir.labs.client.layout.MainLayout;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

public class Offre implements EntryPoint {
	final DataRPCAsync rpc = GWT.create(DataRPC.class);
	private final MainLayout mainLayout = new MainLayout();
	private Model model;
	//private RequestFile fileAsString = new RequestFile();
	public void onModuleLoad() {
		VisualizationUtils.loadVisualizationApi(new Runnable() {
			public void run() {
				RootPanel.get().add(mainLayout);
				addHandlerToDisplay(mainLayout);
			}
		}, CoreChart.PACKAGE);
		rpc.getListCategories(new AsyncCallback<ArrayList<ArrayList<String>>>() {
			public void onSuccess(ArrayList<ArrayList<String>> result) {
				model = new Model(result);
				
			}
			
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				caught.getMessage();
			}
		});
	}
  
	private void addHandlerToDisplay(CategoryDisplay display){
		display.addSelectionHandler(new SelectionHandler<String>() {
			public void onSelection(SelectionEvent<String> event) {
				
				String selectedItem = event.getSelectedItem();
				
				rpc.getListCategories(new AsyncCallback<ArrayList<ArrayList<String>>>() {
					public void onSuccess(ArrayList<ArrayList<String>> result) {
						mainLayout.set_E_DataToDisplay(result);
					}
					
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						caught.getMessage();
					}
				});
			}
		});
	}
}

