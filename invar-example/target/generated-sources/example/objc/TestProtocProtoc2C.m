//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "TestProtocProtoc2C.h"

#define CRC32__ 0xC716EAFC
#define SIZE__  1L

@interface Protoc2C ()
{
    NSMutableDictionary * _hotfix; /* 0 *-map<string,string> */
}
@end

@implementation Protoc2C

- (instancetype) init
{
    self = [super init];
    if (!self) { return self; }
    _hotfix = nil;
    return self;
}
/* Protoc2C::init */

- (void) dealloc
{
    if (_hotfix) { _hotfix = nil; }
}
/* Protoc2C::dealloc */

- (id) copyWithZone:(nullable NSZone *)zone;
{
    id copy = [[[self class] allocWithZone:zone] init];
    DataWriter *writer = [DataWriter CreateWithData:[[NSMutableData alloc] initWithCapacity:[self byteSize]]];
    [self write:writer];
    [copy read:[DataReader CreateWithData:writer.data]];
    return copy;
}
/* Protoc2C::copyWithZone */

- (NSMutableDictionary *) hotfix { return _hotfix; }

- (Protoc2C *) setHotfix : (NSMutableDictionary *)v { _hotfix = v; return self; }

- (NSInteger)read:(const DataReader * const)r
{
    BOOL eof = false;
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
/* Protoc2C::read(...) */

- (NSInteger)write:(DataWriter *)w
{
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
/* Protoc2C::write */

- (NSUInteger)byteSize
{
    NSUInteger size = SIZE__;
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
/* Protoc2C::byteSize */

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
    BOOL hotfixExists = (nil != _hotfix && [_hotfix count] > 0);
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
/* Protoc2C::writeJSON */

@end /* @implementation Protoc2C */
/*
0@test.protoc.Protoc2C/map-string-string
*/

