//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#ifndef InvarProtoc_h
#define InvarProtoc_h

#import <Foundation/Foundation.h>
#import "DataWriter.h"
#import "DataReader.h"

@protocol InvarDecode

- (NSInteger)read:(const DataReader * const)r;

@end

@protocol InvarEncode

- (NSUInteger)byteSize;
- (NSInteger)write:(DataWriter *)w;

@end

@protocol InvarEncodeJSON

- (NSString *)toStringJSON;
- (void)writeJSON:(NSMutableString *)s;

@end

@protocol InvarProtoc <InvarEncode, InvarDecode, InvarEncodeJSON>
- (uint16_t) protocId;
- (uint32_t) protocCRC;
@end

@protocol ProtocNotify <InvarProtoc>
@end

@protocol ProtocRequest <InvarProtoc>

@end

@protocol ProtocResponse <InvarProtoc>
- (uint16_t) protocError;
@end

typedef void (^RecvRequest)(id<ProtocRequest> req, id<ProtocResponse> resp);
typedef void (^RecvResponse)(id<ProtocResponse> resp);
typedef void (^RecvNotify)(id<ProtocNotify> ntf);
typedef void (^HandleError)(NSInteger err, NSInteger protoc);

@interface InvarClient : NSObject
+ (void) handleResponse:(NSData *)data onYes:(RecvResponse)blockResp onErr:(HandleError)blockErr;
// ... handleNotify
// ... handleRequest
@end

#define FORMAT_S        @"%@"
#define LINE_FEED_S     @"\n"
#define QUOTATION_S     @"\""
#define COLON_S         @":"
#define COMMA_S         @","
#define LEFT_SQUARE_S   @"["
#define RIGHT_SQUARE_S  @"]"
#define LEFT_CURLY_S    @"{"
#define RIGHT_CURLY_S   @"}"

#define INVAR_ERR_NONE                     0
#define INVAR_ERR_SIZE_TOO_LONG          493
#define INVAR_ERR_INVALID_REQ            494
#define INVAR_ERR_DECODE_EOF             495
#define INVAR_ERR_DECODE_STRING_P        496
#define INVAR_ERR_DECODE_STRUCT_P        497
#define INVAR_ERR_DECODE_VEC_MAP_P       498
#define INVAR_ERR_PROTOC_CRC_MISMATCH    499
#define INVAR_ERR_PROTOC_UNHANDLED       500
#define INVAR_ERR_PROTOC_INVALID_ID      501
#define INVAR_ERR_PROTOC_NO_HANDLER      503

#endif /* InvarProtoc_h */
