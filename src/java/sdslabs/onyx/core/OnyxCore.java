package sdslabs.onyx.core;

public class OnyxCore.java {

  
  private static String tempDir = "./tmp/";
  private static File indexConfigFile;
  private static OnyxIndexer indexer;
  private static OnyxConfig indexConfig;

  private static ini(){
    indexConfigFile = new File("./indexConfig.xml");
    indexConfig = new OnyxConfig(indexConfigFile);
    indexer = new OnyxIndexer(indexConfig);
  }

  private static File fetchFile(Map<String,String> info){
    
  }

  private static Map<String, List<String>> getKeywords(Map<String,String> info){
    //call the creed engine to get the field info

  }

  public static boolean addFileToIndex(Map<String,String> info){
    ini();
    File tmp = fetchFile(info);
    Map<String, List<String>> keywords = getKeywords(info);
    OnyxDocument doc = OnyxDocumentFactory.create(tmp, keywords);
    indexer.addDocument(doc);
    indexer.index();
  }

  public static boolean addFilesToIndex(List<Map<String,String>> infos){
    ini();
    OnyxDocumentDirectory dir = new OnyxDocumentDirectory();
    for( Map<String,String> info : infos){
      File tmp = fetchFile(info);
      Map<String, List<String>> keywords = getKeywords(info);
      OnyxDocument doc = OnyxDocumentFactory.create(tmp, keywords);
      dir.addDocument(doc);
    }
    indexer.addDocuments(dir);
    indexer.index();
  }

}

