//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#ifndef TESTPROTOCTESTUSERLOGINR2C_H_
#define TESTPROTOCTESTUSERLOGINR2C_H_

#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSString.h>
#import "InvarProtoc.h"
#import "TestProtocProtoc2C.h"

/* 客户端请求,服务端响应 */
@interface TestUserLoginR2C : NSObject <NSCopying, InvarEncode, InvarDecode, InvarEncodeJSON, ProtocResponse>

- (uint16_t             ) protocId   ; /* [AutoAdd] ProtocolID */
- (uint32_t             ) protocCRC  ; /* [AutoAdd] Protocol CRC32 */
- (uint16_t             ) protocError; /* [AutoAdd] Protocol error code */
- (Protoc2C            *) protoc2C   ; /* [AutoAdd] 服务端响应的公共数据 */
- (NSString            *) userId     ; /*  */
- (NSString            *) userName   ; /*  */
- (NSMutableArray      *) roles      ; /*  */
- (NSMutableDictionary *) hotfix     ; /* [AutoAdd] Hotfix */

- (TestUserLoginR2C *) setProtocError: (uint16_t             ) value; /*  uint16 */
- (TestUserLoginR2C *) setProtoc2C   : (Protoc2C            *) value; /*  Test.Protoc.Protoc2C */
- (TestUserLoginR2C *) setUserId     : (NSString            *) value; /*  string */
- (TestUserLoginR2C *) setUserName   : (NSString            *) value; /*  string */
- (TestUserLoginR2C *) setHotfix     : (NSMutableDictionary *) value; /*  map<string,string> */

@end /* @interface TestUserLoginR2C */

#endif /* TESTPROTOCTESTUSERLOGINR2C_H_ */
