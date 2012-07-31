package com.sfeir.labs.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DataRPCAsync {

	void getListCategories(AsyncCallback<ArrayList<ArrayList<String>>> callback);
	

	void getStatsCategorie(String nom, AsyncCallback<StatsCategorie> callback);

	void getDroguerieEntretien(AsyncCallback<String[]> callback);

	void getDroguerieHygiene(AsyncCallback<String[]> callback);

	void getDroguerieTotal(AsyncCallback<String[]> callback);

	void getEnsemble(AsyncCallback<String[]> callback);

	void getEpicerieSalee(AsyncCallback<String[]> callback);

	void getEpicerieSucree(AsyncCallback<String[]> callback);

	void getEpicerieTotal(AsyncCallback<List<String>> callback);

	void getLibreserviceCremerie(AsyncCallback<String[]> callback);

	void getLibreserviceFrais(AsyncCallback<String[]> callback);

	void getLibreserviceGlace(AsyncCallback<String[]> callback);

	void getLibreserviceTotal(AsyncCallback<String[]> callback);

	void getLiquideBierre(AsyncCallback<String[]> callback);

	void getLiquideChampagne(AsyncCallback<String[]> callback);

	void getLiquideEaux(AsyncCallback<String[]> callback);

	void getLiquideTotal(AsyncCallback<String[]> callback);

	void getMoisAn(AsyncCallback<String> callback);

	void getAllCategories(AsyncCallback<List<String>> asyncCallback);


}
