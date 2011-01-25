package sdslabs.onyx.indexer;

public class OnyxIndexer {
  
  private OnyxConfig indexerConfig;
  private HashMap<String, OnyxAnalyzer> analyzers;
  private IndexWriter writer;
  private boolean compound;
  private OnyxDocumentDirectory dir;
  
  public OnyxIndexer(OnyxConfig config){
    
    indexerConfig = config;
    iniAnalysis();
    dir = FSDirectory.getDirectory(config.getIndexDir());
    writer = new IndexWriter(dir, new StandardAnalyzer(), true);
    
  }
  
  private void iniAnalysis(){
    for( int i = 0; i < config.numAnalyzer(); i++){
      analyzers.put(config.getAnalyzer(i), new OnyxAnalyzer(indexerConfig, config.getAnalyzer(i)));    
    }     
  }

  public void addDocument( OnyxDocument doc ){
    
    dir = new OnyxDocumentDirectory();
    dir.addDocument(doc);
    
  }

  public void addDocuments(OnyxDocumentDirectory dir){
    this.dir = dir;
  }

  public void index(){
    
    writer.setUseCompoundField(compound);
    for( OnyxDocument doc = dir.iterateDocument(); doc != null; doc = dir.iterateDocument()){
      writer.addDocument(doc.getDocument(), getAnalyzer(doc.getType()));
    }
    writer.optimize();
    writer.close();

  }
 
  private Analyzer getAnalyzer( String name ){
    return analyzers.get(name);
  }
  
}
