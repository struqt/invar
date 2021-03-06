//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#ifndef TESTPROTOCTESTSERVERTIMEN2C_H_
#define TESTPROTOCTESTSERVERTIMEN2C_H_

#import <Foundation/NSDictionary.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSString.h>
#import "InvarProtoc.h"
#import "TestProtocProtoc2C.h"

/* 服务器通知客户端 */
@interface TestServerTimeN2C : NSObject <NSCopying, InvarEncode, InvarDecode, InvarEncodeJSON, ProtocNotify>

- (uint16_t             ) protocId ; /* [AutoAdd] ProtocolID */
- (uint32_t             ) protocCRC; /* [AutoAdd] Protocol CRC32 */
- (Protoc2C            *) protoc2C ; /* [AutoAdd] 服务端响应的公共数据 */
- (int64_t              ) time     ; /* 现在时间 */
- (NSMutableDictionary *) hotfix   ; /* [AutoAdd] Hotfix */

- (TestServerTimeN2C *) setProtoc2C : (Protoc2C            *) value; /*  Test.Protoc.Protoc2C */
- (TestServerTimeN2C *) setTime     : (int64_t              ) value; /*  int64 */
- (TestServerTimeN2C *) setHotfix   : (NSMutableDictionary *) value; /*  map<string,string> */

@end /* @interface TestServerTimeN2C */

#endif /* TESTPROTOCTESTSERVERTIMEN2C_H_ */
