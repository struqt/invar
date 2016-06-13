//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#ifndef TEST_XYZ_TESTNEST_H_
#define TEST_XYZ_TESTNEST_H_

#import <Foundation/NSString.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSArray.h>
#import "test_abc_Custom.h"
#import "Invar.h"

/* 测试泛型相互嵌套 */
@interface TestNest : NSObject <NSCopying, InvarEncode, InvarDecode, InvarEncodeJSON>

- (NSMutableArray      *) listDict; /*  */
- (NSMutableDictionary *) dictList; /*  */
- (NSMutableArray      *) list5d  ; /* 五维列表 */
- (NSMutableDictionary *) hotfix  ; /* [AutoAdd] Hotfix */

- (TestNest *) setHotfix  : (NSMutableDictionary *) value; /* 3 map<string,string> */

@end /* @interface TestNest */

#endif /* TEST_XYZ_TESTNEST_H_ */
