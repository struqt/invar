//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "test_xyz_TestPointer.h"

#define CRC32 0xDF23C954

@interface TestPointer ()
{
    TestPointer         * _self        ; /* 0 test.xyz.TestPointer */
    NSString            * _stringValue ; /* 1 string */
    Custom              * _other       ; /* 2 test.abc.Custom */
    NSMutableArray      * _listI08     ; /* 3 vec<int8> */
    NSMutableDictionary * _dictI08     ; /* 4 map<int8,int8> */
    NSMutableArray      * _listNested  ; /* 5 vec<vec<vec<vec<test.xyz.TestPointer>>>> */
    float_t               _numberSingle; /* 6 float */
    Gender                _enumValue   ; /* 7 test.abc.Gender */
    NSMutableDictionary * _hotfix      ; /* 8 map<string,string> */
}
@end

@implementation TestPointer

- (instancetype) init
{
    self = [super init];
    if (!self) { return self; }
    _self         = nil;
    _stringValue  = nil;
    _other        = nil;
    _listI08      = nil;
    _dictI08      = nil;
    _listNested   = nil;
    _numberSingle = 0.0F;
    _enumValue    = NONE;
    _hotfix       = nil;
    return self;
}
/* TestPointer::init */

- (void) dealloc
{
    if (_self        ) { _self         = nil; }
    if (_stringValue ) { _stringValue  = nil; }
    if (_other       ) { _other        = nil; }
    if (_listI08     ) { _listI08      = nil; }
    if (_dictI08     ) { _dictI08      = nil; }
    if (_listNested  ) { _listNested   = nil; }
    if (_hotfix      ) { _hotfix       = nil; }
}
/* TestPointer::dealloc */

- (id) copyWithZone:(nullable NSZone *)zone;
{
    id copy = [[[self class] allocWithZone:zone] init];
    DataWriter *writer = [DataWriter Create];
    [self write:writer];
    [copy read:[DataReader CreateWithData:writer.data]];
    return copy;
}
/* TestPointer::copyWithZone */

- (TestPointer         *) self         { return _self        ; }
- (NSString            *) stringValue  { return _stringValue ; }
- (Custom              *) other        { return _other       ; }
- (NSMutableArray      *) listI08      { return _listI08     ; }
- (NSMutableDictionary *) dictI08      { return _dictI08     ; }
- (NSMutableArray      *) listNested   { return _listNested  ; }
- (float_t              ) numberSingle { return _numberSingle; }
- (Gender               ) enumValue    { return _enumValue   ; }
- (NSMutableDictionary *) hotfix       { return _hotfix      ; }

- (TestPointer *) setSelf         : (TestPointer         *)v { _self         = v; return self; }
- (TestPointer *) setStringValue  : (NSString            *)v { _stringValue  = v; return self; }
- (TestPointer *) setOther        : (Custom              *)v { _other        = v; return self; }
- (TestPointer *) setListI08      : (NSMutableArray      *)v { _listI08      = v; return self; }
- (TestPointer *) setDictI08      : (NSMutableDictionary *)v { _dictI08      = v; return self; }
- (TestPointer *) setListNested   : (NSMutableArray      *)v { _listNested   = v; return self; }
- (TestPointer *) setNumberSingle : (float_t              )v { _numberSingle = v; return self; }
- (TestPointer *) setEnumValue    : (Gender               )v { _enumValue    = v; return self; }
- (TestPointer *) setHotfix       : (NSMutableDictionary *)v { _hotfix       = v; return self; }

- (NSInteger)read:(DataReader *)r
{
    BOOL eof = false;
    int8_t selfExists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == selfExists) {
        if (_self == nil) { _self = [[TestPointer alloc] init]; }
        NSInteger selfErr = [_self read:r]; if (selfErr != 0) { return selfErr; }
    }
    else if (0x00 == selfExists) { _self = nil; }
    else { return INVAR_ERR_DECODE_STRUCT_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t stringValueExists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == stringValueExists) {
        _stringValue = [r readString:&eof];
    }
    else if (0x00 == stringValueExists) { _stringValue = nil; }
    else { return INVAR_ERR_DECODE_STRING_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t otherExists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == otherExists) {
        if (_other == nil) { _other = [[Custom alloc] init]; }
        NSInteger otherErr = [_other read:r]; if (otherErr != 0) { return otherErr; }
    }
    else if (0x00 == otherExists) { _other = nil; }
    else { return INVAR_ERR_DECODE_STRUCT_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t listI08Exists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == listI08Exists) {
        if (_listI08 == nil) { _listI08 = [[NSMutableArray alloc] init]; }
        uint32_t lenListI08 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
        for (uint32_t iListI08 = 0; iListI08 < lenListI08; iListI08++) {
            NSNumber *n1 = @([r readInt8:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
            [_listI08 addObject:n1];
        }
    }
    else if (0x00 == listI08Exists) { _listI08 = nil; }
    else { return INVAR_ERR_DECODE_VEC_MAP_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t dictI08Exists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == dictI08Exists) {
        if (_dictI08 == nil) { _dictI08 = [[NSMutableDictionary alloc] init]; }
        uint32_t lenDictI08 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
        for (uint32_t iDictI08 = 0; iDictI08 < lenDictI08; iDictI08++) {
            NSNumber *k1 = @([r readInt8:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
            NSNumber *v1 = @([r readInt8:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
            [_dictI08 setObject:v1 forKey:k1];
        }
    }
    else if (0x00 == dictI08Exists) { _dictI08 = nil; }
    else { return INVAR_ERR_DECODE_VEC_MAP_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t listNestedExists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == listNestedExists) {
        if (_listNested == nil) { _listNested = [[NSMutableArray alloc] init]; }
        uint32_t lenListNested = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
        for (uint32_t iListNested = 0; iListNested < lenListNested; iListNested++) {
            NSMutableArray *n1 = [[NSMutableArray alloc] init]; //read.vec.head
            uint32_t lenN1 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
            for (uint32_t iN1 = 0; iN1 < lenN1; iN1++) {
                NSMutableArray *n2 = [[NSMutableArray alloc] init]; //read.vec.head
                uint32_t lenN2 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
                for (uint32_t iN2 = 0; iN2 < lenN2; iN2++) {
                    NSMutableArray *n3 = [[NSMutableArray alloc] init]; //read.vec.head
                    uint32_t lenN3 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
                    for (uint32_t iN3 = 0; iN3 < lenN3; iN3++) {
                        TestPointer *n4 = [[TestPointer alloc] init];
                        NSInteger n4Err = [n4 read:r]; if (n4Err != 0) { return n4Err; } if (eof) { return INVAR_ERR_DECODE_EOF; }
                        [n3 addObject:n4];
                    }
                    [n2 addObject:n3];
                }
                [n1 addObject:n2];
            }
            [_listNested addObject:n1];
        }
    }
    else if (0x00 == listNestedExists) { _listNested = nil; }
    else { return INVAR_ERR_DECODE_VEC_MAP_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    _numberSingle = [r readFloat:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    _enumValue = (Gender)[r readInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t hotfixExists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == hotfixExists) {
        if (_hotfix == nil) { _hotfix = [[NSMutableDictionary alloc] init]; }
        uint32_t lenHotfix = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
        for (uint32_t iHotfix = 0; iHotfix < lenHotfix; iHotfix++) {
            NSString *k1 = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
            NSString *v1 = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
            [_hotfix setObject:v1 forKey:k1];
        }
    }
    else if (0x00 == hotfixExists) { _hotfix = nil; }
    else { return INVAR_ERR_DECODE_VEC_MAP_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    return INVAR_ERR_NONE;
}
/* TestPointer::read(...) */

- (NSInteger)write:(DataWriter *)w
{
    if (_self != nil) { [w writeInt8:0x01]; [_self write:w]; }
    else { [w writeInt8:0x00]; }
    if (_stringValue != nil) { [w writeInt8:0x01]; [w writeString:_stringValue]; }
    else { [w writeInt8:0x00]; }
    if (_other != nil) { [w writeInt8:0x01]; [_other write:w]; }
    else { [w writeInt8:0x00]; }
    if (_listI08 != nil) {
        [w writeInt8:0x01];
        [w writeUInt32:(uint32_t)[_listI08 count]];
        for (id n1 in _listI08) {
            [w writeInt8:[n1 charValue]];
        }
    } else {
        [w writeInt8:0x00];
    }
    if (_dictI08 != nil) {
        [w writeInt8:0x01];
        [w writeUInt32:(uint32_t)[_dictI08 count]];
        for (id k1 in _dictI08) {
            [w writeInt8:[k1 charValue]];
            int8_t v1 = [[_dictI08 objectForKey:k1] charValue]; [w writeInt8:v1];
        }
    } else {
        [w writeInt8:0x00];
    }
    if (_listNested != nil) {
        [w writeInt8:0x01];
        [w writeUInt32:(uint32_t)[_listNested count]];
        for (id n1 in _listNested) {
            [w writeUInt32:(uint32_t)[n1 count]];
            for (id n2 in n1) {
                [w writeUInt32:(uint32_t)[n2 count]];
                for (id n3 in n2) {
                    [w writeUInt32:(uint32_t)[n3 count]];
                    for (id n4 in n3) {
                        [n4 write:w];
                    }
                }
            }
        }
    } else {
        [w writeInt8:0x00];
    }
    [w writeFloat:_numberSingle];
    [w writeInt32:_enumValue];
    if (_hotfix != nil) {
        [w writeInt8:0x01];
        [w writeUInt32:(uint32_t)[_hotfix count]];
        for (id k1 in _hotfix) {
            [w writeString:k1];
            NSString *v1 = [_hotfix objectForKey:k1];
            [w writeString:v1];
        }
    } else {
        [w writeInt8:0x00];
    }
    return 0;
}
/* TestPointer::write */

- (NSString *)toStringJSON;
{
    NSMutableString *s = [[NSMutableString alloc] init] ;
    [self writeJSON:s];
    return s;
}

- (void)writeJSON:(NSMutableString *)s
{
    [s appendString:LINE_FEED_S]; [s appendString:LEFT_CURLY_S];
    NSString *comma = nil;
    BOOL selfExists = (nil != _self);
    if (selfExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"self"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [_self writeJSON:s]; comma = COMMA_S;
    }
    BOOL stringValueExists = (_stringValue && [_stringValue length] > 0);
    if (comma && stringValueExists) { [s appendString:comma]; comma = nil; }
    if (stringValueExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"stringValue"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [s appendString:QUOTATION_S]; [s appendString:_stringValue]; [s appendString:QUOTATION_S]; comma = COMMA_S;
    }
    BOOL otherExists = (nil != _other);
    if (comma && otherExists) { [s appendString:comma]; comma = nil; }
    if (otherExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"other"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [_other writeJSON:s]; comma = COMMA_S;
    }
    BOOL listI08Exists = (nil != _listI08 && [_listI08 count] > 0);
    if (comma && listI08Exists) { [s appendString:comma]; comma = nil; }
    if (listI08Exists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listI08"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listI08Size = (nil == _listI08 ? 0 : [_listI08 count]);
        if (listI08Size > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listI08Idx = 0;
            for (id n1 in _listI08) {/* vec.for: _listI08 */
                ++listI08Idx;
                [s appendFormat:FORMAT_S, n1];
                if (listI08Idx != listI08Size) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL dictI08Exists = (nil != _dictI08 && [_dictI08 count] > 0);
    if (comma && dictI08Exists) { [s appendString:comma]; comma = nil; }
    if (dictI08Exists) {
        [s appendString:QUOTATION_S]; [s appendString:@"dictI08"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger dictI08Size = (nil == _dictI08 ? 0 : [_dictI08 count]);
        if (dictI08Size > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_CURLY_S];
            int dictI08Idx = 0;
            for (id k1 in _dictI08) { /* map.for: _dictI08 */
                ++dictI08Idx;
                [s appendString:QUOTATION_S]; [s appendFormat:FORMAT_S, k1];
                [s appendString:QUOTATION_S]; [s appendString:COLON_S]; /* nest.k */
                id v1 = [_dictI08 objectForKey:k1];
                [s appendFormat:FORMAT_S, v1]; /* nest.v */
                if (dictI08Idx != dictI08Size) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_CURLY_S];
        } comma = COMMA_S;
    }
    BOOL listNestedExists = (nil != _listNested && [_listNested count] > 0);
    if (comma && listNestedExists) { [s appendString:comma]; comma = nil; }
    if (listNestedExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listNested"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listNestedSize = (nil == _listNested ? 0 : [_listNested count]);
        if (listNestedSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listNestedIdx = 0;
            for (id n1 in _listNested) {/* vec.for: _listNested */
                ++listNestedIdx;
                NSUInteger n1Size = (nil == n1 ? 0 : [n1 count]);
                if (n1Size > 0) {
                    [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
                    int n1Idx = 0;
                    for (id n2 in n1) {/* vec.for: n1 */
                        ++n1Idx;
                        NSUInteger n2Size = (nil == n2 ? 0 : [n2 count]);
                        if (n2Size > 0) {
                            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
                            int n2Idx = 0;
                            for (id n3 in n2) {/* vec.for: n2 */
                                ++n2Idx;
                                NSUInteger n3Size = (nil == n3 ? 0 : [n3 count]);
                                if (n3Size > 0) {
                                    [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
                                    int n3Idx = 0;
                                    for (id n4 in n3) {/* vec.for: n3 */
                                        ++n3Idx;
                                        [n4 writeJSON:s];
                                        if (n3Idx != n3Size) { [s appendString:COMMA_S]; }
                                    }
                                    [s appendString:RIGHT_SQUARE_S];
                                }
                                if (n2Idx != n2Size) { [s appendString:COMMA_S]; }
                            }
                            [s appendString:RIGHT_SQUARE_S];
                        }
                        if (n1Idx != n1Size) { [s appendString:COMMA_S]; }
                    }
                    [s appendString:RIGHT_SQUARE_S];
                }
                if (listNestedIdx != listNestedSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    if (comma) { [s appendString:comma]; comma = nil; }
    [s appendString:QUOTATION_S]; [s appendString:@"numberSingle"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
    comma = COMMA_S; [s appendFormat:FORMAT_S, @(_numberSingle)];
    if (comma) { [s appendString:comma]; comma = nil; }
    [s appendString:QUOTATION_S]; [s appendString:@"enumValue"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
    comma = COMMA_S; [s appendFormat:FORMAT_S, @(_enumValue)];
    BOOL hotfixExists = (nil != _hotfix && [_hotfix count] > 0);
    if (comma && hotfixExists) { [s appendString:comma]; comma = nil; }
    if (hotfixExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"hotfix"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger hotfixSize = (nil == _hotfix ? 0 : [_hotfix count]);
        if (hotfixSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_CURLY_S];
            int hotfixIdx = 0;
            for (id k1 in _hotfix) { /* map.for: _hotfix */
                ++hotfixIdx;
                [s appendString:QUOTATION_S]; [s appendString:k1]; [s appendString:QUOTATION_S]; [s appendString:COLON_S]; /* nest.k.string */
                id v1 = [_hotfix objectForKey:k1];
                [s appendString:QUOTATION_S]; [s appendString:v1]; [s appendString:QUOTATION_S]; /* nest.v */
                if (hotfixIdx != hotfixSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_CURLY_S];
        } comma = COMMA_S;
    }
    [s appendString:RIGHT_CURLY_S]; [s appendString:LINE_FEED_S];
}
/* TestPointer::writeJSON */

@end /* @implementation TestPointer */

