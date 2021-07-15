// Retriever for Tweet Searcher

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retrieval;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.DefaultSimilarity;
import org.apache.lucene.search.similarities.LMDirichletSimilarity;
import org.apache.lucene.search.similarities.LMJelinekMercerSimilarity;
import org.apache.lucene.search.similarities.MultiSimilarity;
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.Version;
//import org.deeplearning4j.datasets.fetchers.BaseDataFetcher;
//import org.nd4j.linalg.api.ndarray.INDArray;
//import org.nd4j.linalg.dataset.DataSet;
//import org.nd4j.linalg.factory.Nd4j;

//import Indexing.JSONDocParser;
//import Dl4j.LuceneDocFetcher;
import org.xml.sax.helpers.DefaultHandler;



/**
 *
 * @author anirban
 */

// Fetch the document text from an existing Lucene index
public class JSONRetriever extends DefaultHandler {
    
   
    //DataSet dataSet;
    
    Properties prop;
    IndexSearcher indexSearcher;
    File indexDir;
    //Analyzer analyzer;

    int globalTermId;
    float lambda = (float) 0.6;
    //Map<String, Integer> termSeen;
    //List<Map<String, Dl4j.TermInfo>> docWordMaps;

    public static final String CONTENET_FIELD_NAME = "words";
    
    public JSONRetriever(String propFile) throws Exception {

        prop = new Properties();
        prop.load(new FileReader(propFile));
        //analyzer = constructAnalyzer();
        String indexPath = prop.getProperty("index");
        indexDir = new File(indexPath);
        
        //indexSearcher = new IndexSearcher(indexDirectory);
        System.out.println(indexPath);
    }
    
    public Document[] processAll(String queryPassed) throws Exception {
        Path p = indexDir.toPath();
        Directory dir = FSDirectory.open(p);
        ArrayList<String> singleQuery = new ArrayList<String>();
        singleQuery.add(queryPassed);     // query
        System.out.println(singleQuery.get(0));

        //System.out.println("Ei holo " + LuceneDocFetcher(dir, singleQuery));
        return LuceneDocFetcher(dir, singleQuery);
    }

    public int RetrievedDocCounter(String queryText) throws Exception {

        Path p = indexDir.toPath();
        Directory dir = FSDirectory.open(p);

        IndexReader reader = DirectoryReader.open(dir);

        int totalExamples = reader.numDocs(); // docIds.size();


        IndexSearcher searcher = new IndexSearcher(reader);
            //Similarity sm = new DefaultSimilarity();

        Similarity[] sims = {
                new LMJelinekMercerSimilarity(lambda),
                new LMDirichletSimilarity(),
                new BM25Similarity(),
                //new DFRSimilarity(new BasicModelBE(), new AfterEffectB(), new NormalizationH1()),
            };
            Similarity sm = new MultiSimilarity(sims);
            
            searcher.setSimilarity(sm);

            //Analyzer analyzer = new KeywordAnalyzer();
            //Analyzer analyzer = new StandardAnalyzer();
            Analyzer analyzer = new EnglishAnalyzer();
            //Analyzer analyzer = new WhitespaceAnalyzer();

            QueryParser queryParser = new QueryParser("words", analyzer);
            Query query = queryParser.parse(queryText);

            TopDocs topDocs = searcher.search(query, 100);
            ScoreDoc[] hits = topDocs.scoreDocs;
            
            return hits.length;
    }
    
    // Iterate over every document in this index and vectorize each
    public Document[] LuceneDocFetcher(Directory dir, ArrayList<String> docIds) throws Exception {

        globalTermId = 0;
        //termSeen = new HashMap<>();

        IndexReader reader = DirectoryReader.open(dir);
        
           
        // totalExamples = reader.numDocs();
        //++Procheta
        int totalExamples = reader.numDocs(); // docIds.size();
        //docWordMaps = new ArrayList<>(totalExamples);

        System.out.println(totalExamples);
        // build the per-doc word maps
//        for (int i = 0; i < totalExamples; i++) {
//
//            Document doc1 = reader.document(i);
//            
//            
//            IndexSearcher searcher = new IndexSearcher(reader);
//            Similarity sm = new DefaultSimilarity();
//            searcher.setSimilarity(sm);
//            Analyzer analyzer = new KeywordAnalyzer();
//            //System.out.println(id);
//            QueryParser queryParser = new QueryParser("id", analyzer);
//            Query query = queryParser.parse(docIds.get(i));
//            TopDocs topDocs = searcher.search(query, 3);
//            //System.out.println(query.toString());
//            ScoreDoc[] hits = topDocs.scoreDocs;
//            // System.out.println(hits.length);
//            Document doc = searcher.doc(hits[0].doc);
//            System.out.println(doc.get("id"));
//
//            //docWordMaps.add(buildTerms(reader, hits[0].doc));
//
//            break;
//        }

        // iterate through the word maps and build the one-hot vectors
//        List<DataSet> allDocVecs = new ArrayList<>(totalExamples);
//        for (Map<String, Dl4j.TermInfo> docwordMap : docWordMaps) {
//            allDocVecs.add(constructTermVector(docwordMap));
//        }
//
//        // Merge all doc vecs into one dataset
//        this.dataSet = DataSet.merge(allDocVecs);

        IndexSearcher searcher = new IndexSearcher(reader);
            //Similarity sm = new DefaultSimilarity();
            Similarity[] sims = {
                new LMJelinekMercerSimilarity(lambda),
                new LMDirichletSimilarity(),
                new BM25Similarity(),
                //new DFRSimilarity(new BasicModelBE(), new AfterEffectB(), new NormalizationH1()),
            };
            Similarity sm = new MultiSimilarity(sims);
        
            searcher.setSimilarity(sm);
            
            //Analyzer analyzer = new KeywordAnalyzer();
            //Analyzer analyzer = new StandardAnalyzer();
            Analyzer analyzer = new EnglishAnalyzer();
            //Analyzer analyzer = new WhitespaceAnalyzer();
            
            //System.out.println(id);
            QueryParser queryParser = new QueryParser("words", analyzer);
            Query query = queryParser.parse(docIds.get(0));
            System.out.println(query.toString());
            TopDocs topDocs = searcher.search(query, 100);
            //System.out.println(query.toString());
            ScoreDoc[] hits = topDocs.scoreDocs;
             System.out.println(hits.length);
             //Document doc = searcher.doc(hits[0].doc);

             Document[] docList = new Document[100];
             //docList.length = hits.length;
             if(hits.length > 0) {
                for (int i = 0; i < hits.length; i++) {
                    docList[i] = searcher.doc(hits[i].doc);
                    System.out.println(docList[i].get("id") + "\t" + docList[i].get("words"));
                }
             }
             else {
                 System.out.println("No match found! :(");
             }

                 
            
            
//            docList[1] = searcher.doc(hits[0].doc);
//            System.out.println(doc.get("id"));
//            System.out.println(doc.get("words"));

            //docWordMaps.add(buildTerms(reader, hits[0].doc));



        reader.close();
        return docList;
    }
        
    
    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[1];
            System.out.println("Usage: java TrecDocIndexer <prop-file>");
            args[0] = "/store/Data/TweetData/TwarcDump/initRetrieve.properties";
            System.out.println(args[0]);
        }

        try {
            JSONRetriever retriever = new JSONRetriever(args[0]);
            retriever.processAll("maga");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
}
