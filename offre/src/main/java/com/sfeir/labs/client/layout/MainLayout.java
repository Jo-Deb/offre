package com.sfeir.labs.client.layout;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Iterables;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.corechart.ColumnChart;
import com.google.gwt.visualization.client.visualizations.corechart.LineChart;
import com.google.gwt.visualization.client.visualizations.corechart.Options;
import com.sfeir.labs.client.CategoryDisplay;
import com.sfeir.labs.client.Model;

public class MainLayout extends Composite implements
		CategoryDisplay {

	private static MainLayoutUiBinder uiBinder = GWT
			.create(MainLayoutUiBinder.class);

	interface MainLayoutUiBinder extends UiBinder<Widget, MainLayout> {
	}
	

	@UiField
	HTMLPanel moisPanel;
	@UiField
	HTMLPanel categoryPanel;
	@UiField
	HTMLPanel affiche;
	@UiField
	Anchor epicerie;
	@UiField
	Anchor liquide;
	@UiField
	Anchor epiceriesale;
	@UiField 
	Anchor epiceriesucre;
	@UiField 
	Anchor frais;
	@UiField
	Anchor cremerie;
	@UiField
	Anchor surgele;
	@UiField
	Anchor hygiene;
	@UiField
	Anchor entretien;
	@UiField
	Anchor dhp;
	@UiField
	Anchor champagne;
	@UiField
	Anchor bierrecidre;
	@UiField
	Anchor sodaeaux;
	@UiField
	Anchor libreservice;
	
	private Model data;

	private final ClickHandler categoryClickHandler = new ClickHandler() {
		public void onClick(ClickEvent event) {
			Anchor source = (Anchor) event.getSource();
			SelectionEvent.fire(MainLayout.this, source.getText());
		}
	};

	public MainLayout() {
		initWidget(uiBinder.createAndBindUi(this));
		epicerie.addClickHandler(categoryClickHandler);
		liquide.addClickHandler(categoryClickHandler);
	}

	public void setCategories(List<String> categoryList) {
		categoryPanel.getElementById("pager").setInnerText("");
		for (final String category : categoryList) {
			HTMLPanel panel = new HTMLPanel("li", "");
			Anchor anchor = new Anchor(category);
			anchor.addClickHandler(categoryClickHandler);
			panel.add(anchor);
			categoryPanel.add(panel, "pager");
		}
	}

	public HandlerRegistration addSelectionHandler(SelectionHandler<String> handler) {
		return addHandler(handler, SelectionEvent.getType());
	}

	public void set_E_DataToDisplay(ArrayList<ArrayList<String>> donnee){
		LineChart line = new LineChart(createTable(donnee), createOptions());
		affiche.clear();
		affiche.add(line);
	}
	
	private AbstractDataTable createTable(ArrayList<ArrayList<String>> donnee){
		this.data = new Model(donnee);
		
		DataTable table = DataTable.create();
		
		table.addColumn(ColumnType.STRING, "mois");
		table.addColumn(ColumnType.NUMBER, "Produits 1er prix");
		table.addColumn(ColumnType.NUMBER, "Tous produits");
		table.addColumn(ColumnType.NUMBER, "Marques Nationales");
		table.addColumn(ColumnType.NUMBER, "Marques Distributeurs");
		//String[] types = {
		table.addRows(data.getEpicerieTotal().size());
		for (int i = 1; i < data.getEpicerieTotal().size(); i++){
			//Recuperation des valeurs de la categorie epicerie
			//pour toutes les types
			//Le type produit 1er prix
			if (data.getEpicerieTotal().get(i).compareTo("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />")>0){
				Iterable<String> entetes = data.getLineSplitter().split(data.getEpicerieTotal().get(i));
				Iterable<String> mois = data.getLineSplitter().split(data.getMoisAn(i));
				table.setValue(i, 0, Iterables.get(mois, 0));
				table.setValue(i, 1, Double.parseDouble(Iterables.get(entetes, 7).replaceAll(",", "\\.")));
				table.setValue(i, 2, Double.parseDouble(Iterables.get(entetes, 1).replaceAll(",", "\\.")));
				table.setValue(i, 3, Double.parseDouble(Iterables.get(entetes, 3).replaceAll(",", "\\.")));
				table.setValue(i, 4, Double.parseDouble(Iterables.get(entetes, 5).replaceAll(",", "\\.")));
			}
		}
		return table;
	}
	
	public void setModel(Model model){
		this.data = model;
	}
	
	public void setMonthsName(){
	}
	
	private Options createOptions() {
	    Options options = Options.create();
	    options.setWidth(500);
	    options.setHeight(240);
	    options.setBackgroundColor("transparent");
	    options.setTitle("LineChart offre");
	    return options;
	  }

	public void removeWid(){
		affiche.clear();
	}
}
