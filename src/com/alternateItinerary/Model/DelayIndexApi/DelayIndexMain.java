package com.alternateItinerary.Model.DelayIndexApi;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DelayIndexMain {

//@SerializedName("request")
//@Expose
//private Request request;
@SerializedName("delayIndexes")
@Expose
private List<DelayIndex> delayIndexes = null;

//public Request getRequest() {
//return request;
//}
//
//public void setRequest(Request request) {
//this.request = request;
//}

public List<DelayIndex> getDelayIndexes() {
return delayIndexes;
}

public void setDelayIndexes(List<DelayIndex> delayIndexes) {
this.delayIndexes = delayIndexes;
}

}