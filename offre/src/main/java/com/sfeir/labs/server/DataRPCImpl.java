package com.sfeir.labs.server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sfeir.labs.client.DataRPC;
import com.sfeir.labs.client.StatsCategorie;

public class DataRPCImpl extends RemoteServiceServlet implements DataRPC {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ArrayList<String>> allInfo;
	private String[] nameOfMonths = {"janvier","fevrier","mars","avril","mai","juin",
			"juillet","aout","septembre","octobre","novembre","decembre"}; 
	private List<String> infoMois;
	private ArrayList<String> allUsage;
	private final Splitter lineSplitter = Splitter.on(";").omitEmptyStrings()
			.trimResults().trimResults(CharMatcher.is('"'));
	private final Splitter fileSplitter = Splitter.on("\n");// .omitEmptyStrings();
	private URLFetchService urlFetchService = URLFetchServiceFactory.getURLFetchService();

	@Override
	public void init() throws ServletException {
		super.init();
		allInfo = new ArrayList<ArrayList<String>>(12);
		infoMois = new ArrayList<String>();
	}

	public ArrayList<ArrayList<String>> getListCategories() {
		allInfo.clear();
			for (int i = 0; i < nameOfMonths.length; i++) {
				HTTPResponse fetch = null;
				try {
					fetch = urlFetchService.fetch(new URL(
							"http://www.data.gouv.fr/var/download/OPM%20grande%20distribution%20DGCCRF%20"
									+ "-%20evolution%20offre%20-%20"+nameOfMonths[i].trim()+"%202011.csv"));
				} catch (MalformedURLException e) {
					System.out.println("URL invalide pour le mois: "+nameOfMonths[i].trim());
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				String result = new String(fetch.getContent(),
						Charset.forName("ISO-8859-1"));
				allInfo.add(Lists.newArrayList(fileSplitter.split(result)));
				//infoMois = Lists.newArrayList(fileSplitter.split(result));
			}
		return allInfo;
	}

	public StatsCategorie getStatsCategorie(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMoisAn() {
		Iterable<String> entetes = lineSplitter.split(infoMois.get(1));
		String moisAn = Iterables.get(entetes, 1);
		return moisAn;
	}

	public List<String> getEpicerieTotal() {
		if (infoMois.isEmpty()) {
			try {
				getListCategories();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<String> result = Lists.newArrayList(lineSplitter.split(infoMois
				.get(4)));
		// String[] array = this.allInfo.get(4).split(";+");
		return result;
	}

	public String[] getEpicerieSalee() {
		String[] array = this.infoMois.get(5).split(";+");
		return array;
	}

	public String[] getEpicerieSucree() {
		String[] array = this.infoMois.get(6).split(";+");
		return array;
	}

	public String[] getLiquideTotal() {
		String[] array = this.infoMois.get(7).split(";+");
		return array;
	}

	public String[] getLiquideEaux() {
		String[] array = this.infoMois.get(8).split(";+");
		return array;
	}

	public String[] getLiquideBierre() {
		String[] array = this.infoMois.get(9).split(";+");
		return array;
	}

	public String[] getLiquideChampagne() {
		String[] array = this.infoMois.get(10).split(";+");
		return array;
	}

	public String[] getLibreserviceTotal() {
		String[] array = this.infoMois.get(11).split(";+");
		return array;
	}

	public String[] getLibreserviceGlace() {
		String[] array = this.infoMois.get(12).split(";+");
		return array;
	}

	public String[] getLibreserviceCremerie() {
		String[] array = this.infoMois.get(13).split(";+");
		return array;
	}

	public String[] getLibreserviceFrais() {
		String[] array = this.infoMois.get(14).split(";+");
		return array;
	}

	public String[] getDroguerieTotal() {
		String[] array = this.infoMois.get(15).split(";+");
		return array;
	}

	public String[] getDroguerieEntretien() {
		String[] array = this.infoMois.get(16).split(";+");
		return array;
	}

	public String[] getDroguerieHygiene() {
		String[] array = this.infoMois.get(17).split(";+");
		return array;
	}

	public String[] getEnsemble() {
		String[] array = this.infoMois.get(18).split(";+");
		return array;
	}

	public List<String> getAllCategories() {
		List<String> result = new ArrayList<String>();
		for (String line : infoMois) {
			result.add(Iterables.get(lineSplitter.split(line), 0, "")
					.replaceAll("dont", ""));
		}
		return result;
	}


}
