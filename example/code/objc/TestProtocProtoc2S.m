//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "TestProtocProtoc2S.h"

#define CRC32 0xC0869FC2

@interface Protoc2S ()
{
    NSString            * _sessionId; /* 0 string */
    NSMutableDictionary * _hotfix   ; /* 1 map<string,string> */
}
@end

@implementation Protoc2S

- (instancetype) init
{
    self = [super init];
    if (!self) { return self; }
    _sessionId = @"";
    _hotfix    = nil;
    return self;
}
/* Protoc2S::init */

- (void) dealloc
{
    if (_sessionId) { _sessionId = nil; }
    if (_hotfix   ) { _hotfix    = nil; }
}
/* Protoc2S::dealloc */

- (id) copyWithZone:(nullable NSZone *)zone;
{
    id copy = [[[self class] allocWithZone:zone] init];
    DataWriter *writer = [DataWriter Create];
    [self write:writer];
    [copy read:[DataReader CreateWithData:writer.data]];
    return copy;
}
/* Protoc2S::copyWithZone */

- (NSString            *) sessionId { return _sessionId; }
- (NSMutableDictionary *) hotfix    { return _hotfix   ; }

- (Protoc2S *) setSessionId : (NSString            *)v { _sessionId = v; return self; }
- (Protoc2S *) setHotfix    : (NSMutableDictionary *)v { _hotfix    = v; return self; }

- (NSInteger)read:(const DataReader * const)r
{
    BOOL eof = false;
    _sessionId = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
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
/* Protoc2S::read(...) */

- (NSInteger)write:(DataWriter *)w
{
    [w writeString:_sessionId];
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
/* Protoc2S::write */

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
    BOOL sessionIdExists = (_sessionId && [_sessionId length] > 0);
    if (sessionIdExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"sessionId"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [s appendString:QUOTATION_S]; [s appendString:_sessionId]; [s appendString:QUOTATION_S]; comma = COMMA_S;
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
/* Protoc2S::writeJSON */

@end /* @implementation Protoc2S */

