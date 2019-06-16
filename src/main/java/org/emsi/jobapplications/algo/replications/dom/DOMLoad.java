package org.emsi.jobapplications.algo.replications.dom;

import java.io.IOException;

import org.jsoup.Jsoup;



public class DOMLoad 
{
	 public static SpecialDocument getPage(DOMType pageType, Object arg) throws IOException
	 {
		 SpecialDocument document = new SpecialDocument();
		 switch(pageType)
		 {
		 	
		 	case offersPage :
		 		document.setDocument(Jsoup.connect( "https://www.emploi.ma/recherche-jobs-maroc?page=" + ((Integer)arg) ).timeout(0).get());
		 		break;
		 	case offer :
		 		document.setDocument(Jsoup.connect( "https://www.emploi.ma" + ((String)arg)).timeout(0).get() );
		 		break;
		 	case enterprise :
		 		document.setDocument( Jsoup.connect( "https://www.emploi.ma" + ((String)arg) ).timeout(0).get() );
		 		break;
		 	case jobSeekersPage :
		 		document.setDocument(Jsoup.connect( "https://www.emploi.ma/recherche-base-donnees-cv?page=" + ((Integer)arg) ).timeout(0).get());
		 		break;
		 	case jobSeeker :
		 		document.setDocument( Jsoup.connect( "https://www.emploi.ma" + ((String)arg) ).timeout(0).get() );
		 		break;
		 	default:
		 		break;
		 }
			 
		 return document;
	 }

}
