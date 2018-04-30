package yapp.devcamp.fallInIdol.googleVision;

import com.google.cloud.vision.spi.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.protobuf.ByteString;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GoogleVision {
	
	public static void main(String[] args) throws Exception {

//	    ImageAnnotatorClient vision = ImageAnnotatorClient.create();

	    String fileName = "/Users/shineeseo/Downloads/sugar.jpg";
	    
	    Path path = Paths.get(fileName);
	    byte[] data = Files.readAllBytes(path);
	    ByteString imgBytes = ByteString.copyFrom(data);

	    List<AnnotateImageRequest> requests = new ArrayList<AnnotateImageRequest>();
	    Image img = Image.newBuilder().setContent(imgBytes).build();
	    Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
	    AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
	        .addFeatures(feat)
	        .setImage(img)
	        .build();
	    requests.add(request);
	    
	    try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
	        BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
	        List<AnnotateImageResponse> responses = response.getResponsesList();

	        for (AnnotateImageResponse res : responses) {
	          if (res.hasError()) {
	        	  	System.out.printf("Error: %s\n", res.getError().getMessage());
	            return;
	          }

	          // For full list of available annotations, see http://g.co/cloud/vision/docs
	          for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
	            annotation.getAllFields().forEach((k, v) -> System.out.printf("%s : %s\n", k, v.toString()));
	          }
	        }
	      }
//	    BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
//
//	    List<AnnotateImageResponse> responses = response.getResponsesList();
//
//	    for (AnnotateImageResponse res : responses) {
//	      if (res.hasError()) {
//	        System.out.printf("Error: %s\n", res.getError().getMessage());
//	        return;
//	      }
//
//	      for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
//	        annotation.getAllFields().forEach((k, v)->System.out.printf("%s : %s\n", k, v.toString()));
//	      }
//	    }
//		
	}
}

