//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#ifndef TEST_PROTOC_TESTUSERLOGIN2S_H_
#define TEST_PROTOC_TESTUSERLOGIN2S_H_

#import <Foundation/NSString.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSDictionary.h>
#import "test_protoc_Protoc2S.h"
#import "Invar.h"

/* 客户端请求,服务端响应 */
@interface TestUserLogin2S : NSObject <NSCopying, InvarEncode, InvarDecode, InvarEncodeJSON>

- (uint16_t             ) protocId ; /* [AutoAdd] ProtocolID */
- (uint32_t             ) protocCRC; /* [AutoAdd] Protocol CRC32 */
- (Protoc2S            *) protoc2S ; /* [AutoAdd] 客户端请求的公共数据 */
- (int64_t              ) userId   ; /*  */
- (NSString            *) platform ; /*  */
- (NSMutableDictionary *) hotfix   ; /* [AutoAdd] Hotfix */

- (TestUserLogin2S *) setProtoc2S : (Protoc2S            *) value; /*  test.protoc.Protoc2S */
- (TestUserLogin2S *) setUserId   : (int64_t              ) value; /*  int64 */
- (TestUserLogin2S *) setPlatform : (NSString            *) value; /*  string */
- (TestUserLogin2S *) setHotfix   : (NSMutableDictionary *) value; /*  map<string,string> */

@end /* @interface TestUserLogin2S */

#endif /* TEST_PROTOC_TESTUSERLOGIN2S_H_ */
