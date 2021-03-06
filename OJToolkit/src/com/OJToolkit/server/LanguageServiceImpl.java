package com.OJToolkit.server;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.OJToolkit.client.Exceptions.NotLoggedInException;
import com.OJToolkit.client.Services.LanguageService;
import com.OJToolkit.client.ValueObjects.LanguageData;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LanguageServiceImpl extends RemoteServiceServlet implements
        LanguageService {

	public static final PersistenceManagerFactory PMF = DataStoreHandler.PMF;
	private static final Logger LOG = Logger
	        .getLogger(LanguageServiceImpl.class.getName());

	/* (non-Javadoc)
	 * @see com.OJToolkit.client.Services.LanguageService#getLanguages(java.lang.String)
	 */
	@Override
	public ArrayList<LanguageData> getLanguages(String OJType) throws NotLoggedInException {
		PersistenceManager pm = DataStoreHandler.getPersistenceManager();
		ArrayList<LanguageData> languages = new ArrayList<LanguageData>();
		try {
			String select_query = "select from " + Language.class.getName();
			Query query = pm.newQuery(select_query);
			query.setFilter("OJType == ojType");
			query.declareParameters("java.lang.String ojType");
			List<Language> languagesDB = (List<Language>) query.execute(OJType);
			for (Language language : languagesDB) {
				languages.add(new LanguageData(language.getLanguageName(),
				        language.getLanguageValue(), language.getOJType()));
			}

		} finally {
			pm.close();
		}
		return languages;
	}

	/* (non-Javadoc)
	 * @see com.OJToolkit.client.Services.LanguageService#addLanguages()
	 */
	@Override
	public void addLanguages() {
		PersistenceManager pm = DataStoreHandler.getPersistenceManager();
		try {
			Query qq = pm.newQuery(Language.class);
			List<Language> ae = (List<Language>) qq.execute();
			pm.deletePersistentAll(ae);
			String[] languages = new String[] { "C++ (g++ 4.0.0-8)",
			        "Pascal (gpc 20070904)", "Perl (perl 5.12.1)",
			        "Python (python 2.5)", "Fortran 95 (gfortran 4.3.2)",
			        "Whitespace (wspace 0.3)", "ADA 95 (gnat 4.3.2)",
			        "Ocaml (ocamlopt 3.10.2)", "Intercal (ick 0.28-4)",
			        "Java (JavaSE 6)", "C (gcc 4.3.2)",
			        "Brainf**k (bff 1.0.3.1)", "Assembler (nasm 2.03.01)",
			        "Clips (clips 6.24)", "Prolog (swipl 5.6.58)",
			        "Icon (iconc 9.4.3)", "Ruby (ruby 1.9.0)",
			        "Scheme (stalin 0.11)", "Pike (pike 7.6.112)",
			        "D (gdc 4.1.3)", "Haskell (ghc 6.10.4)",
			        "Pascal (fpc 2.2.4)", "Smalltalk (gst 3.0.3)",
			        "JAR (JavaSE 6)", "Nice (nicec 0.9.6)", "Lua (luac 5.1.3)",
			        "C# (gmcs 2.0.1)", "Bash (bash-4.0.37)", "PHP (php 5.2.6)",
			        "Nemerle (ncc 0.9.3)", "Common Lisp (sbcl 1.0.18)",
			        "Common Lisp (clisp 2.44.1)", "Scheme (guile 1.8.5)",
			        "C99 strict (gcc 4.3.2)", "JavaScript (rhino 1.7R1-2)",
			        "Erlang (erl 5.6.3)", "Tcl (tclsh 8.5.3)",
			        "Scala (scala 2.8.0)", "C++ (g++ 4.3.2)",
			        "Perl 6 (rakudo-2010.08)", "Text (plain text)",
			        "Clojure (clojure 1.1.0)", "Go (gc 2010-07-14)",
			        "Python 3 (python 3.1.2)", "F# (fsharp 2.0.0)" };

			String[] values = new String[] { "38", "39", "41", "54", "62",
			        "111", "114", "116", "124" };
			Language l = new Language();
			for (int i = 0; i < 36; i++) {
				l.setLanguageName(languages[i]);
				l.setLanguageValue(String.valueOf(i + 1));
				l.setOJType("SPOJ");
				pm.makePersistent(new Language(l.getLanguageName(), l
				        .getLanguageValue(), l.getOJType()));
			}
			for (int i = 36; i < languages.length; i++) {
				l.setLanguageName(languages[i]);
				l.setLanguageValue(values[i - 36]);
				l.setOJType("SPOJ");
				pm.makePersistent(new Language(l.getLanguageName(), l
				        .getLanguageValue(), l.getOJType()));
			}
			String[] languages_Timus = new String[] { "Pascal" , "Java" , "C", "C++", "C#" };
			String[] values_Timus = new String[] { "3" , "7" , "9", "10", "11" };
			for(int i=0;i<languages_Timus.length;i++){
				l.setLanguageName(languages_Timus[i]);
				l.setLanguageValue(values_Timus[i]);
				l.setOJType("Timus");
				pm.makePersistent(new Language(l.getLanguageName(), l
				      .getLanguageValue(), l.getOJType()));
			}

			l = new Language();
			String[] languages_UVA = new String[] { "ANSI C" , "JAVA 1.6.0" , "C++ 4.1.2", "PASCAL 2.0.4" };
			String[] values_UVA = new String[] { "1" , "2" , "3", "4" };
			for(int i=0;i<languages_UVA.length;i++){
				l.setLanguageName(languages_UVA[i]);
				l.setLanguageValue(values_UVA[i]);
				l.setOJType("UVA");
				pm.makePersistent(new Language(l.getLanguageName(), l
				      .getLanguageValue(), l.getOJType()));
			}
			
			
			l = new Language();
			String[] languages_LA = new String[] { "ANSI C" , "JAVA 1.6.0" , "C++ 4.1.2", "PASCAL 2.0.4" };
			String[] values_LA = new String[] { "1" , "2" , "3", "4" };
			for(int i=0;i<languages_LA.length;i++){
				l.setLanguageName(languages_LA[i]);
				l.setLanguageValue(values_LA[i]);
				l.setOJType("LiveArchive");
				pm.makePersistent(new Language(l.getLanguageName(), l
						.getLanguageValue(), l.getOJType()));
			}

		} finally {
			pm.close();
		}

	}
	
	



}
