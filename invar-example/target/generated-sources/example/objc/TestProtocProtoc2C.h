//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#ifndef TESTPROTOCPROTOC2C_H_
#define TESTPROTOCPROTOC2C_H_

#import <Foundation/NSDictionary.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSString.h>
#import "InvarProtoc.h"

/* 服务端响应的公共数据 */
@interface Protoc2C : NSObject <NSCopying, InvarEncode, InvarDecode, InvarEncodeJSON>

- (NSMutableDictionary *) hotfix; /* [AutoAdd] Hotfix */

- (Protoc2C *) setHotfix: (NSMutableDictionary *) value; /* 0 map<string,string> */

@end /* @interface Protoc2C */

#endif /* TESTPROTOCPROTOC2C_H_ */
