//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "TestXyzTestList.h"

#define CRC32__ 0x5FD1194A
#define SIZE__  56L

@interface TestList ()
{
    NSMutableArray * _listI08    ; /* 0 &-vec<int8> */
    NSMutableArray * _listI16    ; /* 1 &-vec<int16> */
    NSMutableArray * _listI32    ; /* 2 &-vec<int32> */
    NSMutableArray * _listI64    ; /* 3 &-vec<int64> */
    NSMutableArray * _listU08    ; /* 4 &-vec<uint8> */
    NSMutableArray * _listU16    ; /* 5 &-vec<uint16> */
    NSMutableArray * _listU32    ; /* 6 &-vec<uint32> */
    NSMutableArray * _listU64    ; /* 7 &-vec<uint64> */
    NSMutableArray * _listSingle ; /* 8 &-vec<float> */
    NSMutableArray * _listDouble ; /* 9 &-vec<double> */
    NSMutableArray * _listBoolean; /* 10 &-vec<bool> */
    NSMutableArray * _listString ; /* 11 &-vec<string> */
    NSMutableArray * _listEnum   ; /* 12 &-vec<Test.Abc.Gender> */
    NSMutableArray * _listStruct ; /* 13 &-vec<Test.Abc.Custom> */
}
@end

@implementation TestList

- (instancetype) init
{
    self = [super init];
    if (!self) { return self; }
    _listI08     = [[NSMutableArray alloc] init];
    _listI16     = [[NSMutableArray alloc] init];
    _listI32     = [[NSMutableArray alloc] init];
    _listI64     = [[NSMutableArray alloc] init];
    _listU08     = [[NSMutableArray alloc] init];
    _listU16     = [[NSMutableArray alloc] init];
    _listU32     = [[NSMutableArray alloc] init];
    _listU64     = [[NSMutableArray alloc] init];
    _listSingle  = [[NSMutableArray alloc] init];
    _listDouble  = [[NSMutableArray alloc] init];
    _listBoolean = [[NSMutableArray alloc] init];
    _listString  = [[NSMutableArray alloc] init];
    _listEnum    = [[NSMutableArray alloc] init];
    _listStruct  = [[NSMutableArray alloc] init];
    return self;
}
/* TestList::init */

- (void) dealloc
{
    if (_listI08    ) { _listI08     = nil; }
    if (_listI16    ) { _listI16     = nil; }
    if (_listI32    ) { _listI32     = nil; }
    if (_listI64    ) { _listI64     = nil; }
    if (_listU08    ) { _listU08     = nil; }
    if (_listU16    ) { _listU16     = nil; }
    if (_listU32    ) { _listU32     = nil; }
    if (_listU64    ) { _listU64     = nil; }
    if (_listSingle ) { _listSingle  = nil; }
    if (_listDouble ) { _listDouble  = nil; }
    if (_listBoolean) { _listBoolean = nil; }
    if (_listString ) { _listString  = nil; }
    if (_listEnum   ) { _listEnum    = nil; }
    if (_listStruct ) { _listStruct  = nil; }
}
/* TestList::dealloc */

- (id) copyWithZone:(nullable NSZone *)zone;
{
    id copy = [[[self class] allocWithZone:zone] init];
    DataWriter *writer = [DataWriter CreateWithData:[[NSMutableData alloc] initWithCapacity:[self byteSize]]];
    [self write:writer];
    [copy read:[DataReader CreateWithData:writer.data]];
    return copy;
}
/* TestList::copyWithZone */

- (NSMutableArray *) listI08     { return _listI08    ; }
- (NSMutableArray *) listI16     { return _listI16    ; }
- (NSMutableArray *) listI32     { return _listI32    ; }
- (NSMutableArray *) listI64     { return _listI64    ; }
- (NSMutableArray *) listU08     { return _listU08    ; }
- (NSMutableArray *) listU16     { return _listU16    ; }
- (NSMutableArray *) listU32     { return _listU32    ; }
- (NSMutableArray *) listU64     { return _listU64    ; }
- (NSMutableArray *) listSingle  { return _listSingle ; }
- (NSMutableArray *) listDouble  { return _listDouble ; }
- (NSMutableArray *) listBoolean { return _listBoolean; }
- (NSMutableArray *) listString  { return _listString ; }
- (NSMutableArray *) listEnum    { return _listEnum   ; }
- (NSMutableArray *) listStruct  { return _listStruct ; }

- (NSInteger)read:(const DataReader * const)r
{
    BOOL eof = false;
    uint32_t lenListI08 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListI08 = 0; iListI08 < lenListI08; iListI08++) {
        NSNumber *n1 = @([r readInt8:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listI08 addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListI16 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListI16 = 0; iListI16 < lenListI16; iListI16++) {
        NSNumber *n1 = @([r readInt16:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listI16 addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListI32 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListI32 = 0; iListI32 < lenListI32; iListI32++) {
        NSNumber *n1 = @([r readInt32:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listI32 addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListI64 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListI64 = 0; iListI64 < lenListI64; iListI64++) {
        NSNumber *n1 = @([r readInt64:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listI64 addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListU08 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListU08 = 0; iListU08 < lenListU08; iListU08++) {
        NSNumber *n1 = @([r readUInt8:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listU08 addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListU16 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListU16 = 0; iListU16 < lenListU16; iListU16++) {
        NSNumber *n1 = @([r readUInt16:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listU16 addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListU32 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListU32 = 0; iListU32 < lenListU32; iListU32++) {
        NSNumber *n1 = @([r readUInt32:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listU32 addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListU64 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListU64 = 0; iListU64 < lenListU64; iListU64++) {
        NSNumber *n1 = @([r readUInt64:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listU64 addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListSingle = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListSingle = 0; iListSingle < lenListSingle; iListSingle++) {
        NSNumber *n1 = @([r readFloat:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listSingle addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListDouble = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListDouble = 0; iListDouble < lenListDouble; iListDouble++) {
        NSNumber *n1 = @([r readDouble:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listDouble addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListBoolean = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListBoolean = 0; iListBoolean < lenListBoolean; iListBoolean++) {
        id n1 = @([r readBool:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listBoolean addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListString = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListString = 0; iListString < lenListString; iListString++) {
        NSString *n1 = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listString addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListEnum = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListEnum = 0; iListEnum < lenListEnum; iListEnum++) {
        id n1 = @((Gender)[r readInt32:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listEnum addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenListStruct = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListStruct = 0; iListStruct < lenListStruct; iListStruct++) {
        Custom *n1 = [[Custom alloc] init];
        NSInteger n1Err = [n1 read:r]; if (n1Err != 0) { return n1Err; } if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_listStruct addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    return INVAR_ERR_NONE;
}
/* TestList::read(...) */

- (NSInteger)write:(DataWriter *)w
{
    [w writeUInt32:(uint32_t)[_listI08 count]];
    for (id n1 in _listI08) {
        [w writeInt8:[n1 charValue]];
    }
    [w writeUInt32:(uint32_t)[_listI16 count]];
    for (id n1 in _listI16) {
        [w writeInt16:[n1 shortValue]];
    }
    [w writeUInt32:(uint32_t)[_listI32 count]];
    for (id n1 in _listI32) {
        [w writeInt32:[n1 intValue]];
    }
    [w writeUInt32:(uint32_t)[_listI64 count]];
    for (id n1 in _listI64) {
        [w writeInt64:[n1 longValue]];
    }
    [w writeUInt32:(uint32_t)[_listU08 count]];
    for (id n1 in _listU08) {
        [w writeUInt8:[n1 unsignedCharValue]];
    }
    [w writeUInt32:(uint32_t)[_listU16 count]];
    for (id n1 in _listU16) {
        [w writeUInt16:[n1 unsignedShortValue]];
    }
    [w writeUInt32:(uint32_t)[_listU32 count]];
    for (id n1 in _listU32) {
        [w writeUInt32:[n1 unsignedIntValue]];
    }
    [w writeUInt32:(uint32_t)[_listU64 count]];
    for (id n1 in _listU64) {
        [w writeUInt64:[n1 unsignedLongValue]];
    }
    [w writeUInt32:(uint32_t)[_listSingle count]];
    for (id n1 in _listSingle) {
        [w writeFloat:[n1 floatValue]];
    }
    [w writeUInt32:(uint32_t)[_listDouble count]];
    for (id n1 in _listDouble) {
        [w writeDouble:[n1 doubleValue]];
    }
    [w writeUInt32:(uint32_t)[_listBoolean count]];
    for (id n1 in _listBoolean) {
        [w writeUInt8:[n1 unsignedCharValue]];
    }
    [w writeUInt32:(uint32_t)[_listString count]];
    for (id n1 in _listString) {
        [w writeString:n1];
    }
    [w writeUInt32:(uint32_t)[_listEnum count]];
    for (id n1 in _listEnum) {
        [w writeInt32:[n1 intValue]];
    }
    [w writeUInt32:(uint32_t)[_listStruct count]];
    for (id n1 in _listStruct) {
        [n1 write:w];
    }
    return 0;
}
/* TestList::write */

- (NSUInteger)byteSize
{
    NSUInteger size = SIZE__;
    if ([_listI08 count] > 0) { size += [_listI08 count] * 1; }
    if ([_listI16 count] > 0) { size += [_listI16 count] * 2; }
    if ([_listI32 count] > 0) { size += [_listI32 count] * 4; }
    if ([_listI64 count] > 0) { size += [_listI64 count] * 8; }
    if ([_listU08 count] > 0) { size += [_listU08 count] * 1; }
    if ([_listU16 count] > 0) { size += [_listU16 count] * 2; }
    if ([_listU32 count] > 0) { size += [_listU32 count] * 4; }
    if ([_listU64 count] > 0) { size += [_listU64 count] * 8; }
    if ([_listSingle count] > 0) { size += [_listSingle count] * 4; }
    if ([_listDouble count] > 0) { size += [_listDouble count] * 8; }
    if ([_listBoolean count] > 0) { size += [_listBoolean count] * 1; }
    size += sizeof(uint32_t);
    for (id n1 in _listString) {
        size += [n1 length];
    }
    if ([_listEnum count] > 0) { size += [_listEnum count] * 4; }
    size += sizeof(uint32_t);
    for (id n1 in _listStruct) {
        size += [n1 byteSize];
    }
    return size;
}
/* TestList::byteSize */

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
    BOOL listI08Exists = (nil != _listI08 && [_listI08 count] > 0);
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
    BOOL listI16Exists = (nil != _listI16 && [_listI16 count] > 0);
    if (comma && listI16Exists) { [s appendString:comma]; comma = nil; }
    if (listI16Exists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listI16"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listI16Size = (nil == _listI16 ? 0 : [_listI16 count]);
        if (listI16Size > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listI16Idx = 0;
            for (id n1 in _listI16) {/* vec.for: _listI16 */
                ++listI16Idx;
                [s appendFormat:FORMAT_S, n1];
                if (listI16Idx != listI16Size) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listI32Exists = (nil != _listI32 && [_listI32 count] > 0);
    if (comma && listI32Exists) { [s appendString:comma]; comma = nil; }
    if (listI32Exists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listI32"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listI32Size = (nil == _listI32 ? 0 : [_listI32 count]);
        if (listI32Size > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listI32Idx = 0;
            for (id n1 in _listI32) {/* vec.for: _listI32 */
                ++listI32Idx;
                [s appendFormat:FORMAT_S, n1];
                if (listI32Idx != listI32Size) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listI64Exists = (nil != _listI64 && [_listI64 count] > 0);
    if (comma && listI64Exists) { [s appendString:comma]; comma = nil; }
    if (listI64Exists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listI64"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listI64Size = (nil == _listI64 ? 0 : [_listI64 count]);
        if (listI64Size > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listI64Idx = 0;
            for (id n1 in _listI64) {/* vec.for: _listI64 */
                ++listI64Idx;
                [s appendFormat:FORMAT_S, n1];
                if (listI64Idx != listI64Size) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listU08Exists = (nil != _listU08 && [_listU08 count] > 0);
    if (comma && listU08Exists) { [s appendString:comma]; comma = nil; }
    if (listU08Exists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listU08"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listU08Size = (nil == _listU08 ? 0 : [_listU08 count]);
        if (listU08Size > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listU08Idx = 0;
            for (id n1 in _listU08) {/* vec.for: _listU08 */
                ++listU08Idx;
                [s appendFormat:FORMAT_S, n1];
                if (listU08Idx != listU08Size) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listU16Exists = (nil != _listU16 && [_listU16 count] > 0);
    if (comma && listU16Exists) { [s appendString:comma]; comma = nil; }
    if (listU16Exists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listU16"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listU16Size = (nil == _listU16 ? 0 : [_listU16 count]);
        if (listU16Size > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listU16Idx = 0;
            for (id n1 in _listU16) {/* vec.for: _listU16 */
                ++listU16Idx;
                [s appendFormat:FORMAT_S, n1];
                if (listU16Idx != listU16Size) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listU32Exists = (nil != _listU32 && [_listU32 count] > 0);
    if (comma && listU32Exists) { [s appendString:comma]; comma = nil; }
    if (listU32Exists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listU32"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listU32Size = (nil == _listU32 ? 0 : [_listU32 count]);
        if (listU32Size > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listU32Idx = 0;
            for (id n1 in _listU32) {/* vec.for: _listU32 */
                ++listU32Idx;
                [s appendFormat:FORMAT_S, n1];
                if (listU32Idx != listU32Size) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listU64Exists = (nil != _listU64 && [_listU64 count] > 0);
    if (comma && listU64Exists) { [s appendString:comma]; comma = nil; }
    if (listU64Exists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listU64"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listU64Size = (nil == _listU64 ? 0 : [_listU64 count]);
        if (listU64Size > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listU64Idx = 0;
            for (id n1 in _listU64) {/* vec.for: _listU64 */
                ++listU64Idx;
                [s appendFormat:FORMAT_S, n1];
                if (listU64Idx != listU64Size) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listSingleExists = (nil != _listSingle && [_listSingle count] > 0);
    if (comma && listSingleExists) { [s appendString:comma]; comma = nil; }
    if (listSingleExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listSingle"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listSingleSize = (nil == _listSingle ? 0 : [_listSingle count]);
        if (listSingleSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listSingleIdx = 0;
            for (id n1 in _listSingle) {/* vec.for: _listSingle */
                ++listSingleIdx;
                [s appendFormat:FORMAT_S, n1];
                if (listSingleIdx != listSingleSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listDoubleExists = (nil != _listDouble && [_listDouble count] > 0);
    if (comma && listDoubleExists) { [s appendString:comma]; comma = nil; }
    if (listDoubleExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listDouble"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listDoubleSize = (nil == _listDouble ? 0 : [_listDouble count]);
        if (listDoubleSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listDoubleIdx = 0;
            for (id n1 in _listDouble) {/* vec.for: _listDouble */
                ++listDoubleIdx;
                [s appendFormat:FORMAT_S, n1];
                if (listDoubleIdx != listDoubleSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listBooleanExists = (nil != _listBoolean && [_listBoolean count] > 0);
    if (comma && listBooleanExists) { [s appendString:comma]; comma = nil; }
    if (listBooleanExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listBoolean"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listBooleanSize = (nil == _listBoolean ? 0 : [_listBoolean count]);
        if (listBooleanSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listBooleanIdx = 0;
            for (id n1 in _listBoolean) {/* vec.for: _listBoolean */
                ++listBooleanIdx;
                [s appendString:n1 ? @"true" : @"false"];
                if (listBooleanIdx != listBooleanSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listStringExists = (nil != _listString && [_listString count] > 0);
    if (comma && listStringExists) { [s appendString:comma]; comma = nil; }
    if (listStringExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listString"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listStringSize = (nil == _listString ? 0 : [_listString count]);
        if (listStringSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listStringIdx = 0;
            for (id n1 in _listString) {/* vec.for: _listString */
                ++listStringIdx;
                [s appendString:QUOTATION_S]; [s appendString:n1]; [s appendString:QUOTATION_S];
                if (listStringIdx != listStringSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listEnumExists = (nil != _listEnum && [_listEnum count] > 0);
    if (comma && listEnumExists) { [s appendString:comma]; comma = nil; }
    if (listEnumExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listEnum"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listEnumSize = (nil == _listEnum ? 0 : [_listEnum count]);
        if (listEnumSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listEnumIdx = 0;
            for (id n1 in _listEnum) {/* vec.for: _listEnum */
                ++listEnumIdx;
                [s appendFormat:FORMAT_S, n1];
                if (listEnumIdx != listEnumSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL listStructExists = (nil != _listStruct && [_listStruct count] > 0);
    if (comma && listStructExists) { [s appendString:comma]; comma = nil; }
    if (listStructExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listStruct"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listStructSize = (nil == _listStruct ? 0 : [_listStruct count]);
        if (listStructSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listStructIdx = 0;
            for (id n1 in _listStruct) {/* vec.for: _listStruct */
                ++listStructIdx;
                [n1 writeJSON:s];
                if (listStructIdx != listStructSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    [s appendString:RIGHT_CURLY_S]; [s appendString:LINE_FEED_S];
}
/* TestList::writeJSON */

@end /* @implementation TestList */
/*
1@test.xyz.TestList/vec-int8/vec-int16/vec-int32/vec-int64/vec-uint8/vec-uint16/vec-uint32/vec-uint6
  4/vec-float/vec-double/vec-bool/vec-string/vec-int32/vec-test.abc.Custom
+@test.abc.Custom/int32/test.abc.TestBasic/test.xyz.Conflict/test.abc.Conflict/vec-test.abc.Custom/i
  nt32/string/string/test.abc.Custom/test.abc.Custom/string
*/

