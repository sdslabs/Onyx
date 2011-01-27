package sdslabs.onyx.document;

import java.io.File;
import java.io.FileInputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tike.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

public class OnyxDocumentFactory {


  public static OnyxDocument create(File file, Map<String, List<String>> assocKeywords){

    FileInputStream fileStream = new FileInputStream(file);
    ContentHandler contentHandler = new BodyContentHandler();
    
    Metadata metadata = new Metadata();
    metadata.set(Metadata.RESOURCE_NAME_KEY, file.getName());
    Parser parser = new AutoDetectParser();
    parser.parse(fileStream, contentHandler, metadata);
    String type = metadata.get(Metadata.CONTENT_TYPE);

    if( type.compareTo("application/vnd.ms-excel") == 0){
      return new OnyxMSEXCELDocument(file, assocKeyword);
    }else if(type.compareTo("application/msword") == 0){
      return new OnyxMSWORDDocument(file, assocKeyword);
    }else if(type.compareTo("application/vnd.ms-powerpoint") == 0){
      return new OnyxMSPPTDocument(file, assocKeyword);
    }else if(type.compareTo("application/xml") == 0){
      return new OnyxXMLDocument(file, assocKeyword);
    }else if(type.compareTo("text/html") == 0){
      return new OnyxTextDocument(file, assocKeyword);
    }else if(type.compareTo("application/vnd.oasis.opendocument.text") == 0){
      return new OnyxODFTextDocument(file, assocKeyword);
    }else if(type.compareTo("application/vnd.oasis.opendocument.presentation") == 0){
      return new OnyxODFPPTDocument(file, assocKeyword);
    }else if(type.compareTo("application/pdf") == 0){
      return new OnyxPDFDocument(file, assocKeyword);
    }else if(type.compareTo("text/plain") == 0){
      return new OnyxTextDocument(file, assocKeyword);
    }else if(type.compareTo("application/rtf") == 0){
      return new OnyxRTFDocument(file, assocKeyword);
    }

  }
  
}

