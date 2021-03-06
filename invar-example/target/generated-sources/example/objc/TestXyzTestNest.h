//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#ifndef TESTXYZTESTNEST_H_
#define TESTXYZTESTNEST_H_

#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSString.h>
#import "InvarProtoc.h"
#import "TestAbcCustom.h"

/* 测试泛型相互嵌套 */
@interface TestNest : NSObject <NSCopying, InvarEncode, InvarDecode, InvarEncodeJSON>

- (NSMutableArray      *) listDict; /*  */
- (NSMutableDictionary *) dictList; /*  */
- (NSMutableArray      *) list5d  ; /* 五维列表 */

@end /* @interface TestNest */

#endif /* TESTXYZTESTNEST_H_ */
