//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "TestProtocTestUserLocationN2S.h"

#define CRC32 0xEC953457

@interface TestUserLocationN2S ()
{
    uint16_t              _protocId ; /*  uint16 */
    uint32_t              _protocCRC; /*  uint32 */
    Protoc2S            * _protoc2S ; /*  Test.Protoc.Protoc2S */
    float_t               _x        ; /*  float */
    float_t               _y        ; /*  float */
    NSMutableDictionary * _hotfix   ; /*  map<string,string> */
}
@end

@implementation TestUserLocationN2S

- (instancetype) init
{
    self = [super init];
    if (!self) { return self; }
    _protocId  = 65531;
    _protocCRC = CRC32;
    _protoc2S  = nil;
    _x         = 0.0F;
    _y         = 0.0F;
    _hotfix    = nil;
    return self;
}
/* TestUserLocationN2S::init */

- (void) dealloc
{
    if (_protoc2S ) { _protoc2S  = nil; }
    if (_hotfix   ) { _hotfix    = nil; }
}
/* TestUserLocationN2S::dealloc */

- (id) copyWithZone:(nullable NSZone *)zone;
{
    id copy = [[[self class] allocWithZone:zone] init];
    DataWriter *writer = [DataWriter Create];
    [self write:writer];
    [copy read:[DataReader CreateWithData:writer.data]];
    return copy;
}
/* TestUserLocationN2S::copyWithZone */

- (uint16_t             ) protocId  { return _protocId ; }
- (uint32_t             ) protocCRC { return _protocCRC; }
- (Protoc2S            *) protoc2S  { return _protoc2S ; }
- (float_t              ) x         { return _x        ; }
- (float_t              ) y         { return _y        ; }
- (NSMutableDictionary *) hotfix    { return _hotfix   ; }

- (TestUserLocationN2S *) setProtoc2S  : (Protoc2S            *)v { _protoc2S  = v; return self; }
- (TestUserLocationN2S *) setX         : (float_t              )v { _x         = v; return self; }
- (TestUserLocationN2S *) setY         : (float_t              )v { _y         = v; return self; }
- (TestUserLocationN2S *) setHotfix    : (NSMutableDictionary *)v { _hotfix    = v; return self; }

- (NSInteger)read:(const DataReader * const)r
{
    BOOL eof = false;
    _protocId = [r readUInt16:&eof];
    if (65531 != _protocId) { _protocId = 65531; return INVAR_ERR_PROTOC_INVALID_ID; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    _protocCRC = [r readUInt32:&eof]; if (CRC32 != _protocCRC) { return INVAR_ERR_PROTOC_CRC_MISMATCH; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t protoc2SExists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == protoc2SExists) {
        if (_protoc2S == nil) { _protoc2S = [[Protoc2S alloc] init]; }
        NSInteger protoc2SErr = [_protoc2S read:r]; if (protoc2SErr != 0) { return protoc2SErr; }
    }
    else if (0x00 == protoc2SExists) { _protoc2S = nil; }
    else { return INVAR_ERR_DECODE_STRUCT_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    _x = [r readFloat:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    _y = [r readFloat:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
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
/* TestUserLocationN2S::read(...) */

- (NSInteger)write:(DataWriter *)w
{
    [w writeUInt16:_protocId];
    [w writeUInt32:_protocCRC];
    if (_protoc2S != nil) { [w writeInt8:0x01]; [_protoc2S write:w]; }
    else { [w writeInt8:0x00]; }
    [w writeFloat:_x];
    [w writeFloat:_y];
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
/* TestUserLocationN2S::write */

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
    BOOL protoc2SExists = (nil != _protoc2S);
    if (comma && protoc2SExists) { [s appendString:comma]; comma = nil; }
    if (protoc2SExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"protoc2S"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [_protoc2S writeJSON:s]; comma = COMMA_S;
    }
    if (comma) { [s appendString:comma]; comma = nil; }
    [s appendString:QUOTATION_S]; [s appendString:@"x"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
    comma = COMMA_S; [s appendFormat:FORMAT_S, @(_x)];
    if (comma) { [s appendString:comma]; comma = nil; }
    [s appendString:QUOTATION_S]; [s appendString:@"y"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
    comma = COMMA_S; [s appendFormat:FORMAT_S, @(_y)];
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
/* TestUserLocationN2S::writeJSON */

@end /* @implementation TestUserLocationN2S */
/*
1@test.protoc.TestUserLocationN2S/uint16/uint32/test.protoc.Protoc2S/float/float/map-string-string
+@test.protoc.Protoc2S/string/map-string-string
*/

