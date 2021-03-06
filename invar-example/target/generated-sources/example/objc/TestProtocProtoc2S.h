//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#ifndef TESTPROTOCPROTOC2S_H_
#define TESTPROTOCPROTOC2S_H_

#import <Foundation/NSDictionary.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSString.h>
#import "InvarProtoc.h"

/* 客户端请求的公共数据 */
@interface Protoc2S : NSObject <NSCopying, InvarEncode, InvarDecode, InvarEncodeJSON>

- (NSString            *) sessionId; /* 会话Id */
- (NSMutableDictionary *) hotfix   ; /* [AutoAdd] Hotfix */

- (Protoc2S *) setSessionId: (NSString            *) value; /* 0 string */
- (Protoc2S *) setHotfix   : (NSMutableDictionary *) value; /* 1 map<string,string> */

@end /* @interface Protoc2S */

#endif /* TESTPROTOCPROTOC2S_H_ */
