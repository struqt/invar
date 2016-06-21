//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "TestProtocTestHeartBeat2C.h"

#define CRC32__ 0xCC52B7AE
#define SIZE__  8L

@interface TestHeartBeat2C ()
{
    uint16_t              _protocId ; /*  &-uint16 */
    uint32_t              _protocCRC; /*  &-uint32 */
    Protoc2C            * _protoc2C ; /*  *-Test.Protoc.Protoc2C */
    NSMutableDictionary * _hotfix   ; /*  *-map<string,string> */
}
@end

@implementation TestHeartBeat2C

- (instancetype) init
{
    self = [super init];
    if (!self) { return self; }
    _protocId  = 65534;
    _protocCRC = CRC32__;
    _protoc2C  = nil;
    _hotfix    = nil;
    return self;
}
/* TestHeartBeat2C::init */

- (void) dealloc
{
    if (_protoc2C ) { _protoc2C  = nil; }
    if (_hotfix   ) { _hotfix    = nil; }
}
/* TestHeartBeat2C::dealloc */

- (id) copyWithZone:(nullable NSZone *)zone;
{
    id copy = [[[self class] allocWithZone:zone] init];
    DataWriter *writer = [DataWriter CreateWithData:[[NSMutableData alloc] initWithCapacity:[self byteSize]]];
    [self write:writer];
    [copy read:[DataReader CreateWithData:writer.data]];
    return copy;
}
/* TestHeartBeat2C::copyWithZone */

- (uint16_t             ) protocId  { return _protocId ; }
- (uint32_t             ) protocCRC { return _protocCRC; }
- (Protoc2C            *) protoc2C  { return _protoc2C ; }
- (NSMutableDictionary *) hotfix    { return _hotfix   ; }

- (TestHeartBeat2C *) setProtoc2C  : (Protoc2C            *)v { _protoc2C  = v; return self; }
- (TestHeartBeat2C *) setHotfix    : (NSMutableDictionary *)v { _hotfix    = v; return self; }

- (NSInteger)read:(const DataReader * const)r
{
    BOOL eof = false;
    _protocId = [r readUInt16:&eof];
    if (65534 != _protocId) { _protocId = 65534; return INVAR_ERR_PROTOC_INVALID_ID; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    _protocCRC = [r readUInt32:&eof]; if (CRC32__ != _protocCRC) { return INVAR_ERR_PROTOC_CRC_MISMATCH; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t protoc2CExists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == protoc2CExists) {
        if (_protoc2C == nil) { _protoc2C = [[Protoc2C alloc] init]; }
        NSInteger protoc2CErr = [_protoc2C read:r]; if (protoc2CErr != 0) { return protoc2CErr; }
    }
    else if (0x00 == protoc2CExists) { _protoc2C = nil; }
    else { return INVAR_ERR_DECODE_STRUCT_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
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
/* TestHeartBeat2C::read(...) */

- (NSInteger)write:(DataWriter *)w
{
    [w writeUInt16:_protocId];
    [w writeUInt32:_protocCRC];
    if (_protoc2C != nil) { [w writeInt8:0x01]; [_protoc2C write:w]; }
    else { [w writeInt8:0x00]; }
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
/* TestHeartBeat2C::write */

- (NSUInteger)byteSize
{
    NSUInteger size = SIZE__;
    if (_protoc2C != nil) { size += [_protoc2C byteSize]; }
    if (_hotfix != nil) {
        size += sizeof(uint32_t);
        for (id k1 in _hotfix) {
            size += [k1 length];
            NSString *v1 = [_hotfix objectForKey:k1];
            size += [v1 length];
        }
    }
    return size;
}
/* TestHeartBeat2C::byteSize */

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
    [s appendString:QUOTATION_S]; [s appendString:@"protocId"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
    comma = COMMA_S; [s appendFormat:FORMAT_S, @(_protocId)];
    if (comma) { [s appendString:comma]; comma = nil; }
    [s appendString:QUOTATION_S]; [s appendString:@"protocCRC"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
    comma = COMMA_S; [s appendFormat:FORMAT_S, @(_protocCRC)];
    BOOL protoc2CExists = (nil != _protoc2C);
    if (comma && protoc2CExists) { [s appendString:comma]; comma = nil; }
    if (protoc2CExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"protoc2C"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [_protoc2C writeJSON:s]; comma = COMMA_S;
    }
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
/* TestHeartBeat2C::writeJSON */

@end /* @implementation TestHeartBeat2C */
/*
1@test.protoc.TestHeartBeat2C/uint16/uint32/test.protoc.Protoc2C/map-string-string
+@test.protoc.Protoc2C/map-string-string
*/

