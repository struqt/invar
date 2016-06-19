//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#ifndef TESTPROTOCTESTUSERLOCATIONN2S_H_
#define TESTPROTOCTESTUSERLOCATIONN2S_H_

#import <Foundation/NSValue.h>
#import <Foundation/NSString.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSDictionary.h>
#import "TestProtocProtoc2S.h"
#import "InvarProtoc.h"

/* 客户端通知服务端 */
@interface TestUserLocationN2S : NSObject <NSCopying, InvarEncode, InvarDecode, InvarEncodeJSON, ProtocNotify>

- (uint16_t             ) protocId ; /* [AutoAdd] ProtocolID */
- (uint32_t             ) protocCRC; /* [AutoAdd] Protocol CRC32 */
- (Protoc2S            *) protoc2S ; /* [AutoAdd] 客户端请求的公共数据 */
- (float_t              ) x        ; /* 坐标X */
- (float_t              ) y        ; /* 坐标Y */
- (NSMutableDictionary *) hotfix   ; /* [AutoAdd] Hotfix */

- (TestUserLocationN2S *) setProtoc2S : (Protoc2S            *) value; /*  Test.Protoc.Protoc2S */
- (TestUserLocationN2S *) setX        : (float_t              ) value; /*  float */
- (TestUserLocationN2S *) setY        : (float_t              ) value; /*  float */
- (TestUserLocationN2S *) setHotfix   : (NSMutableDictionary *) value; /*  map<string,string> */

@end /* @interface TestUserLocationN2S */

#endif /* TESTPROTOCTESTUSERLOCATIONN2S_H_ */
