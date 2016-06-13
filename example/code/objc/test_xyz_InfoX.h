//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#ifndef TEST_XYZ_INFOX_H_
#define TEST_XYZ_INFOX_H_

#import <Foundation/NSString.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSArray.h>
#import "test_xyz_Conflict.h"
#import "test_abc_Info.h"
#import "test_abc_Gender.h"
#import "test_abc_Conflict.h"
#import "Invar.h"

/* Complex data structure */
@interface InfoX : NSObject <NSCopying, InvarEncode, InvarDecode, InvarEncodeJSON>

- (NSMutableArray      *) infos     ; /*  */
- (test_xyz_Conflict   *) conflict_x; /* Two types with the same name. */
- (test_abc_Conflict   *) conflict_a; /* Two types with the same name. */
- (NSMutableDictionary *) mConflict ; /*  */
- (NSMutableArray      *) info2d    ; /* 2 dimension list */
- (NSMutableArray      *) info3d    ; /* 3 dimension list */
- (NSMutableArray      *) info5d    ; /*  */
- (NSMutableArray      *) infovm    ; /*  */
- (NSMutableDictionary *) mvei      ; /*  */
- (NSMutableDictionary *) mive      ; /*  */
- (NSMutableDictionary *) mvive     ; /*  */
- (NSMutableArray      *) vmvive    ; /*  */
- (NSMutableDictionary *) hotfix    ; /* [AutoAdd] Hotfix */

- (InfoX *) setConflict_x: (test_xyz_Conflict   *) value; /* 1 test.xyz.Conflict */
- (InfoX *) setConflict_a: (test_abc_Conflict   *) value; /* 2 test.abc.Conflict */
- (InfoX *) setHotfix    : (NSMutableDictionary *) value; /* 12 map<string,string> */

@end /* @interface InfoX */

#endif /* TEST_XYZ_INFOX_H_ */
