package vinh.plk.vidu.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vinh.plk.vidu.Photo;

public interface ServicePhoto {
    @GET("photos")
    Call<List<Photo>> getAllPhtos();

}
