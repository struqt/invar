//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#ifndef TEST_ABC_TESTBASIC_H_
#define TEST_ABC_TESTBASIC_H_

#import <Foundation/NSValue.h>
#import <Foundation/NSString.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSDictionary.h>
#import "test_abc_Gender.h"
#import "InvarProtoc.h"

/* 基础类型 */
@interface TestBasic : NSObject <NSCopying, InvarEncode, InvarDecode, InvarEncodeJSON>

- (int8_t               ) numberI08   ; /* 有符号的8位整数 */
- (int16_t              ) numberI16   ; /* 有符号的16位整数 */
- (int32_t              ) numberI32   ; /* 有符号的32位整数 */
- (int64_t              ) numberI64   ; /* 有符号的64位整数 */
- (uint8_t              ) numberU08   ; /* 无符号的8位整数 */
- (uint16_t             ) numberU16   ; /* 无符号的16位整数 */
- (uint32_t             ) numberU32   ; /* 无符号的32位整数 */
- (uint64_t             ) numberU64   ; /* 无符号的64位整数 */
- (float_t              ) numberSingle; /* 单精度浮点小数 */
- (double_t             ) numberDouble; /* 双精度浮点小数 */
- (boolean_t            ) boolValue   ; /* 布尔值 */
- (NSString            *) stringValue ; /* 字符串 */
- (Gender               ) enumValue   ; /* 枚举值 */
- (Gender               ) enumDeft    ; /* 枚举值制定默认值 */
- (NSMutableDictionary *) hotfix      ; /* [AutoAdd] Hotfix */

- (TestBasic *) setNumberI08   : (int8_t               ) value; /* 0 int8 */
- (TestBasic *) setNumberI16   : (int16_t              ) value; /* 1 int16 */
- (TestBasic *) setNumberI32   : (int32_t              ) value; /* 2 int32 */
- (TestBasic *) setNumberI64   : (int64_t              ) value; /* 3 int64 */
- (TestBasic *) setNumberU08   : (uint8_t              ) value; /* 4 uint8 */
- (TestBasic *) setNumberU16   : (uint16_t             ) value; /* 5 uint16 */
- (TestBasic *) setNumberU32   : (uint32_t             ) value; /* 6 uint32 */
- (TestBasic *) setNumberU64   : (uint64_t             ) value; /* 7 uint64 */
- (TestBasic *) setNumberSingle: (float_t              ) value; /* 8 float */
- (TestBasic *) setNumberDouble: (double_t             ) value; /* 9 double */
- (TestBasic *) setBoolValue   : (boolean_t            ) value; /* 10 bool */
- (TestBasic *) setStringValue : (NSString            *) value; /* 11 string */
- (TestBasic *) setEnumValue   : (Gender               ) value; /* 12 test.abc.Gender */
- (TestBasic *) setEnumDeft    : (Gender               ) value; /* 13 test.abc.Gender */
- (TestBasic *) setHotfix      : (NSMutableDictionary *) value; /* 14 map<string,string> */

@end /* @interface TestBasic */

#endif /* TEST_ABC_TESTBASIC_H_ */
