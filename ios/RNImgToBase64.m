
#import "RNImgToBase64.h"

@implementation RNImgToBase64

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(convert:(NSString *) imgUrl
                  findEventsWithResolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject
                  )
{
  @try {
    NSURL *url = [NSURL URLWithString:imgUrl];
    NSURLSession *session = [NSURLSession sharedSession];
    NSURLSessionDownloadTask *task = [session downloadTaskWithURL:url completionHandler:^(NSURL * _Nullable location, NSURLResponse * _Nullable response, NSError * _Nullable error) {
      NSData *imgData = [NSData dataWithContentsOfURL:location];
      NSString *base64 = [imgData base64EncodedStringWithOptions:0];
      if(error != nil) reject(@"ImgToBase64Module", @"convert err", error);
      resolve(base64);
    }];
    [task resume];
  }
  @catch(NSError * e) {
    reject(@"ImgToBase64Module", @"convert err", e);
  }

}

@end