//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "test_abc_Conflict.h"

#define CRC32 0xF938CCBC

@interface test_abc_Conflict ()
{
    Gender                _key   ; /* 0 test.abc.Gender */
    NSString            * _text  ; /* 1 string */
    NSMutableArray      * _bytes ; /* 2 vec<int8> */
    NSMutableDictionary * _hotfix; /* 3 map<string,string> */
}
@end

@implementation test_abc_Conflict

- (instancetype) init
{
    self = [super init];
    if (!self) { return self; }
    _key    = NONE;
    _text   = @"";
    _bytes  = [[NSMutableArray alloc] init];
    _hotfix = nil;
    return self;
}
/* Conflict::init */

- (void) dealloc
{
    if (_text  ) { _text   = nil; }
    if (_bytes ) { _bytes  = nil; }
    if (_hotfix) { _hotfix = nil; }
}
/* Conflict::dealloc */

- (id) copyWithZone:(nullable NSZone *)zone;
{
    id copy = [[[self class] allocWithZone:zone] init];
    DataWriter *writer = [DataWriter Create];
    [self write:writer];
    [copy read:[DataReader CreateWithData:writer.data]];
    return copy;
}
/* Conflict::copyWithZone */

- (Gender               ) key    { return _key   ; }
- (NSString            *) text   { return _text  ; }
- (NSMutableArray      *) bytes  { return _bytes ; }
- (NSMutableDictionary *) hotfix { return _hotfix; }

- (test_abc_Conflict *) setKey    : (Gender               )v { _key    = v; return self; }
- (test_abc_Conflict *) setText   : (NSString            *)v { _text   = v; return self; }
- (test_abc_Conflict *) setHotfix : (NSMutableDictionary *)v { _hotfix = v; return self; }

- (NSInteger)read:(DataReader *)r
{
    BOOL eof = false;
    _key = (Gender)[r readInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    _text = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenBytes = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iBytes = 0; iBytes < lenBytes; iBytes++) {
        NSNumber *n1 = @([r readInt8:&eof]); if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_bytes addObject:n1];
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
/* Conflict::read(...) */

- (NSInteger)write:(DataWriter *)w
{
    [w writeInt32:_key];
    [w writeString:_text];
    [w writeUInt32:(uint32_t)[_bytes count]];
    for (id n1 in _bytes) {
        [w writeInt8:[n1 charValue]];
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
/* Conflict::write */

- (NSString *)toStringJSON;
{
    NSMutableString *s = [[NSMutableString alloc] init] ;
    [self writeJSON:s];
    return s;
}

- (void)writeJSON:(NSMutableString *)s
{
    [s appendString:@"\n"]; [s appendString:@"{"];
    NSString *comma = nil;
    [s appendString:@"\""]; [s appendString:@"key"]; [s appendString:@"\""]; [s appendString:@":"];
    comma = @","; [s appendFormat:@"%@", @(_key)];
    BOOL textExists = (nil != _text && ![@"" isEqual:_text]);
    if (comma && textExists) { [s appendString:comma]; comma = nil; }
    if (textExists) {
        [s appendString:@"\""]; [s appendString:@"text"]; [s appendString:@"\""]; [s appendString:@":"];
        comma = @","; [s appendString:@"\""]; [s appendString:_text]; [s appendString:@"\""];
    }
    BOOL bytesExists = (nil != _bytes && [_bytes count] > 0);
    if (comma && bytesExists) { [s appendString:comma]; comma = nil; }
    if (bytesExists) {
        [s appendString:@"\""]; [s appendString:@"bytes"];
        [s appendString:@"\""]; [s appendString:@":"]; comma = @","; }
    NSUInteger bytesSize = (nil == _bytes ? 0 : [_bytes count]);
    if (bytesSize > 0) {
        [s appendString:@"\n"]; [s appendString:@"["];
        int bytesIdx = 0;
        for (id n1 in _bytes) {/* vec.for: _bytes */
            ++bytesIdx;
            [s appendFormat:@"%@", n1];
            if (bytesIdx != bytesSize) { [s appendString:@","]; }
        }
        [s appendString:@"]"];
    }
    BOOL hotfixExists = (nil != _hotfix && [_hotfix count] > 0);
    if (comma && hotfixExists) { [s appendString:comma]; comma = nil; }
    if (hotfixExists) {
        NSUInteger hotfixSize = (nil == _hotfix ? 0 : [_hotfix count]);
        if (hotfixSize > 0) {
            [s appendString:@"\n"]; [s appendString:@"{"];
            int hotfixIdx = 0;
            for (id k1 in _hotfix) { /* map.for: _hotfix */
                ++hotfixIdx;
                [s appendString:@"\""]; [s appendString:@"\""]; [s appendString:k1]; [s appendString:@"\""];
                [s appendString:@"\""]; [s appendString:@":"]; /* nest.k */
                id v1 = [_hotfix objectForKey:k1];
                [s appendString:@"\""]; [s appendString:v1]; [s appendString:@"\""]; /* nest.v */
                if (hotfixIdx != hotfixSize) { [s appendString:@","]; }
            }
            [s appendString:@"}"];
        } comma = @",";
    }
    [s appendString:@"}"]; [s appendString:@"\n"];
}
/* Conflict::writeJSON */

@end /* @implementation test_abc_Conflict */

