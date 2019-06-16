package org.emsi.jobapplications.algo.replications.dom;


import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SpecialDocument
{
	
	private Document document;
	
	public SpecialDocument() 
	{
		
	}
	
	public SpecialDocument(Document document) 
	{
		this.setDocument(document);
	}

	public Document getDocument() 
	{
		return document;
	}

	public void setDocument(Document document) 
	{
		this.document = document;
	}



	public String selectTextFromHTML(String cssQuery)
	{
		return this.document.select(cssQuery).text();
	}
	
	public String selectElementFromHTML(String cssQuery, String pattern)
	{
		try
		{
			for (Element e : this.document.select(cssQuery)) 
			{
				if(e.text().contains(pattern))
					return e.text();
			}
			return "";
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
	public String selectElementFromHTMLParsed(String cssQuery, String pattern)
	{
		return selectElementFromHTML(cssQuery, pattern).replaceAll(pattern, "");
	}
	
	public String[] selectElementsFromHTML(String cssQuery)
	{
		return this.document.select(cssQuery).text().replaceAll(" - ", ", ").replaceAll("\n", ", ").split(", ");
	}
	
	public String[] selectElementsFromSimpleHTML(String cssQuery)
	{
		return this.document.select(cssQuery).text().replaceAll("\n", ", ").split(", ");
	}
	
	public ArrayList<String> selectSimpleElementsFromHTML(String cssQuery)
	{
		ArrayList<String> result = new ArrayList<String>();
		this.document.select(cssQuery).forEach(e -> result.add(e.text()));
		return result;
	}
	
	public ArrayList<String> selectElementsFromHTMLParsed(String cssQuery)
	{
		ArrayList<String> result = new ArrayList<String>();
		this.document.select(cssQuery).forEach(e -> {result.addAll(Arrays.asList(e.text().replaceAll(" - ", ", ").split(", ")));});
		return result;
	}
	
	public ArrayList<String> selectElementsFromHTMLFiltred(String cssQuery, String pattern)
	{
		ArrayList<String> result = new ArrayList<String>();
		this.document.select(cssQuery).forEach(e -> {result.addAll(Arrays.asList(e.text().replaceAll(pattern, "").replaceAll(" - ", ", ").split(", ")));});
		return result;
	}
	
	public String selectRelativeLinkFromHref(String cssQuery)
	{
		return this.document.select(cssQuery).attr("href");
	}
	
	public String selectAbsoluteLinkFromHref(String cssQuery)
	{
		return this.document.select(cssQuery).attr("abs:href");
	}




}