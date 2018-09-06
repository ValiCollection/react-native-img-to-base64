
package com.developersoul;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNImgToBase64Module extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNImgToBase64Module(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNImgToBase64";
  }

    private String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    @ReactMethod
    public void convert(String imageUrl, Promise promise) {
        try {
            Uri imageUri = Uri.parse(imageUrl);
            Picasso.Builder picasso = new Picasso.Builder(getReactApplicationContext());
            Bitmap image =  picasso.build().load(imageUri).get();
            String response = bitmapToBase64(image);
            promise.resolve(response);
        } catch(Exception err) {
            Log.e("IMAGE TO BASE64", err.getMessage());
            promise.reject(err);
        }

    }
}