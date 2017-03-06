//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "TestProtocTestUserLoginR2C.h"

#define CRC32__ 0x3840542A
#define SIZE__  24L

@interface TestUserLoginR2C ()
{
    int32_t               _protocError; /*  &-int32 */
    uint16_t              _protocId   ; /*  &-uint16 */
    uint32_t              _protocCRC  ; /*  &-uint32 */
    Protoc2C            * _protoc2C   ; /*  *-Test.Protoc.Protoc2C */
    NSString            * _userId     ; /*  &-string */
    NSString            * _userName   ; /*  &-string */
    NSMutableArray      * _roles      ; /*  &-vec<int32> */
    NSMutableDictionary * _hotfix     ; /*  *-map<string,string> */
}
@end

@implementation TestUserLoginR2C

- (instancetype) init
{
    self = [super init];
    if (!self) { return self; }
    _protocError = 0;
    _protocId    = 65528;
    _protocCRC   = CRC32__;
    _protoc2C    = nil;
    _userId      = @"";
    _userName    = @"";
    _roles       = [[NSMutableArray alloc] init];
    _hotfix      = nil;
    return self;
}
/* TestUserLoginR2C::init */

- (void) dealloc
{
    if (_protoc2C   ) { _protoc2C    = nil; }
    if (_userId     ) { _userId      = nil; }
    if (_userName   ) { _userName    = nil; }
    if (_roles      ) { _roles       = nil; }
    if (_hotfix     ) { _hotfix      = nil; }
}
/* TestUserLoginR2C::dealloc */

- (id) copyWithZone:(nullable NSZone *)zone;
{
    id copy = [[[self class] allocWithZone:zone] init];
    DataWriter *writer = [DataWriter CreateWithData:[[NSMutableData alloc] initWithCapacity:[self byteSize]]];
    [self write:writer];
    [copy read:[DataReader CreateWithData:writer.data]];
    return copy;
}
/* TestUserLoginR2C::copyWithZone */

- (int32_t              ) protocError { return _protocError; }
- (uint16_t             ) protocId    { return _protocId   ; }
- (uint32_t             ) protocCRC   { return _protocCRC  ; }
- (Protoc2C            *) protoc2C    { return _protoc2C   ; }
- (NSString            *) userId      { return _userId     ; }
- (NSString            *) userName    { return _userName   ; }
- (NSMutableArray      *) roles       { return _roles      ; }
- (NSMutableDictionary *) hotfix      { return _hotfix     ; }

- (TestUserLoginR2C *) setProtocError : (int32_t              )v { _protocError = v; return self; }
- (TestUserLoginR2C *) setProtoc2C    : (Protoc2C            *)v { _protoc2C    = v; return self; }
- (TestUserLoginR2C *) setUserId      : (NSString            *)v { _userId      = v; return self; }
- (TestUserLoginR2C *) setUserName    : (NSString            *)v { _userName    = v; return self; }
- (TestUserLoginR2C *) setHotfix      : (NSMutableDictionary *)v { _hotfix      = v; return self; }

- (NSInteger)read:(const DataReader * const)r
{
    BOOL eof = false;
    _protocError = [r readInt32:&eof];if (_protocError != 0) { return _protocError; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    _protocId = [r readUInt16:&eof];
    if (65528 != _protocId) { _protocId = 65528; return INVAR_ERR_PROTOC_INVALID_ID; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    _protocCRC = [r readUInt32:&eof]; if (CRC32__ != _protocCRC) { return INVAR_ERR_PROTOC_CRC_MISMATCH; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t protoc2CExists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == protoc2CExists) {
        if (_protoc2C == nil) { _protoc2C = [[Protoc2C alloc] init]; }
        NSInteger protoc2CErr = [_protoc2C read:r]; if (protoc2CErr != 0) { return protoc2CErr; }
    }
    else if (0x00 == protoc2CExists) { _protoc2C = nil; }
    else { return INVAR_ERR_DECODE_STRUCT_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    _userId = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    _userName = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenRoles = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iRoles = 0; iRoles < lenRoles; iRoles++) {
        NSNumber *n1 = @([r readInt32:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_roles addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
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
/* TestUserLoginR2C::read(...) */

- (NSInteger)write:(DataWriter *)w
{
    [w writeInt32:_protocError];
    if (_protocError != 0) { return _protocError; }
    [w writeUInt16:_protocId];
    [w writeUInt32:_protocCRC];
    if (_protoc2C != nil) { [w writeInt8:0x01]; [_protoc2C write:w]; }
    else { [w writeInt8:0x00]; }
    [w writeString:_userId];
    [w writeString:_userName];
    [w writeUInt32:(uint32_t)[_roles count]];
    for (id n1 in _roles) {
        [w writeInt32:[n1 intValue]];
    }
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
/* TestUserLoginR2C::write */

- (NSUInteger)byteSize
{
    NSUInteger size = SIZE__;
    if (_protoc2C != nil) { size += [_protoc2C byteSize]; }
    size += [_userId length];
    size += [_userName length];
    if ([_roles count] > 0) { size += [_roles count] * 4; }
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
/* TestUserLoginR2C::byteSize */

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
    [s appendString:QUOTATION_S]; [s appendString:@"protocError"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
    comma = COMMA_S; [s appendFormat:FORMAT_S, @(_protocError)];
    if (comma) { [s appendString:comma]; comma = nil; }
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
    BOOL userIdExists = (_userId && [_userId length] > 0);
    if (comma && userIdExists) { [s appendString:comma]; comma = nil; }
    if (userIdExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"userId"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [s appendString:QUOTATION_S]; [s appendString:_userId]; [s appendString:QUOTATION_S]; comma = COMMA_S;
    }
    BOOL userNameExists = (_userName && [_userName length] > 0);
    if (comma && userNameExists) { [s appendString:comma]; comma = nil; }
    if (userNameExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"userName"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [s appendString:QUOTATION_S]; [s appendString:_userName]; [s appendString:QUOTATION_S]; comma = COMMA_S;
    }
    BOOL rolesExists = (nil != _roles && [_roles count] > 0);
    if (comma && rolesExists) { [s appendString:comma]; comma = nil; }
    if (rolesExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"roles"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger rolesSize = (nil == _roles ? 0 : [_roles count]);
        if (rolesSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int rolesIdx = 0;
            for (id n1 in _roles) {/* vec.for: _roles */
                ++rolesIdx;
                [s appendFormat:FORMAT_S, n1];
                if (rolesIdx != rolesSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
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
/* TestUserLoginR2C::writeJSON */

@end /* @implementation TestUserLoginR2C */
/*
1@test.protoc.TestUserLoginR2C/int32/uint16/uint32/test.protoc.Protoc2C/string/string/vec-int32/map-
  string-string
+@test.protoc.Protoc2C/map-string-string
*/

