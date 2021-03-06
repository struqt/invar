//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "TestXyzConfigRoot.h"

#define CRC32__ 0x6D03BB9B
#define SIZE__  5L

@interface ConfigRoot ()
{
    NSString            * _revision; /* f0 &-string */
    TestList            * _list    ; /* f1 &-Test.Xyz.TestList */
    TestDict            * _dict    ; /* f2 &-Test.Xyz.TestDict */
    TestNest            * _nest    ; /* f3 &-Test.Xyz.TestNest */
    Info                * _info    ; /* f4 &-Test.Abc.Info */
    InfoX               * _infox   ; /* f5 &-Test.Xyz.InfoX */
    NSMutableDictionary * _hotfix  ; /* f6 *-map<string,string> */
}
@end

@implementation ConfigRoot

- (instancetype) init
{
    self = [super init];
    if (!self) { return self; }
    _revision = @"1.0.0";
    _list     = [[TestList alloc] init];
    _dict     = [[TestDict alloc] init];
    _nest     = [[TestNest alloc] init];
    _info     = [[Info alloc] init];
    _infox    = [[InfoX alloc] init];
    _hotfix   = nil;
    return self;
}
/* ConfigRoot::init */

- (void) dealloc
{
    if (_revision) { _revision = nil; }
    if (_list    ) { _list     = nil; }
    if (_dict    ) { _dict     = nil; }
    if (_nest    ) { _nest     = nil; }
    if (_info    ) { _info     = nil; }
    if (_infox   ) { _infox    = nil; }
    if (_hotfix  ) { _hotfix   = nil; }
}
/* ConfigRoot::dealloc */

- (id) copyWithZone:(nullable NSZone *)zone;
{
    id copy = [[[self class] allocWithZone:zone] init];
    DataWriter *writer = [DataWriter CreateWithData:[[NSMutableData alloc] initWithCapacity:[self byteSize]]];
    [self write:writer];
    [copy read:[DataReader CreateWithData:writer.data]];
    return copy;
}
/* ConfigRoot::copyWithZone */

- (NSString            *) revision { return _revision; }
- (TestList            *) list     { return _list    ; }
- (TestDict            *) dict     { return _dict    ; }
- (TestNest            *) nest     { return _nest    ; }
- (Info                *) info     { return _info    ; }
- (InfoX               *) infox    { return _infox   ; }
- (NSMutableDictionary *) hotfix   { return _hotfix  ; }

- (ConfigRoot *) setRevision : (NSString            *)v { _revision = v; return self; }
- (ConfigRoot *) setList     : (TestList            *)v { _list     = v; return self; }
- (ConfigRoot *) setDict     : (TestDict            *)v { _dict     = v; return self; }
- (ConfigRoot *) setNest     : (TestNest            *)v { _nest     = v; return self; }
- (ConfigRoot *) setInfo     : (Info                *)v { _info     = v; return self; }
- (ConfigRoot *) setInfox    : (InfoX               *)v { _infox    = v; return self; }
- (ConfigRoot *) setHotfix   : (NSMutableDictionary *)v { _hotfix   = v; return self; }

- (NSInteger)read:(const DataReader * const)r
{
    BOOL eof = false;
    _revision = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    NSInteger listErr = [_list read:r]; if (listErr != 0) { return listErr; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    NSInteger dictErr = [_dict read:r]; if (dictErr != 0) { return dictErr; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    NSInteger nestErr = [_nest read:r]; if (nestErr != 0) { return nestErr; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    NSInteger infoErr = [_info read:r]; if (infoErr != 0) { return infoErr; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    NSInteger infoxErr = [_infox read:r]; if (infoxErr != 0) { return infoxErr; } if (eof) { return INVAR_ERR_DECODE_EOF; }
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
/* ConfigRoot::read(...) */

- (NSInteger)write:(DataWriter *)w
{
    [w writeString:_revision];
    [_list write:w];
    [_dict write:w];
    [_nest write:w];
    [_info write:w];
    [_infox write:w];
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
/* ConfigRoot::write */

- (NSUInteger)byteSize
{
    NSUInteger size = SIZE__;
    size += [_revision length];
    size += [_list byteSize];
    size += [_dict byteSize];
    size += [_nest byteSize];
    size += [_info byteSize];
    size += [_infox byteSize];
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
/* ConfigRoot::byteSize */

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
    BOOL revisionExists = (_revision && [_revision length] > 0);
    if (revisionExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"revision"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [s appendString:QUOTATION_S]; [s appendString:_revision]; [s appendString:QUOTATION_S]; comma = COMMA_S;
    }
    BOOL listExists = (nil != _list);
    if (comma && listExists) { [s appendString:comma]; comma = nil; }
    if (listExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"list"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [_list writeJSON:s]; comma = COMMA_S;
    }
    BOOL dictExists = (nil != _dict);
    if (comma && dictExists) { [s appendString:comma]; comma = nil; }
    if (dictExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"dict"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [_dict writeJSON:s]; comma = COMMA_S;
    }
    BOOL nestExists = (nil != _nest);
    if (comma && nestExists) { [s appendString:comma]; comma = nil; }
    if (nestExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"nest"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [_nest writeJSON:s]; comma = COMMA_S;
    }
    BOOL infoExists = (nil != _info);
    if (comma && infoExists) { [s appendString:comma]; comma = nil; }
    if (infoExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"info"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [_info writeJSON:s]; comma = COMMA_S;
    }
    BOOL infoxExists = (nil != _infox);
    if (comma && infoxExists) { [s appendString:comma]; comma = nil; }
    if (infoxExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"infox"]; [s appendString:QUOTATION_S];
        [s appendString:COLON_S]; [_infox writeJSON:s]; comma = COMMA_S;
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
/* ConfigRoot::writeJSON */

@end /* @implementation ConfigRoot */
/*
5@test.xyz.ConfigRoot/string/test.xyz.TestList/test.xyz.TestDict/test.xyz.TestNest/test.abc.Info/tes
  t.xyz.InfoX/map-string-string
+@test.abc.Info/int32/int8/int16/int32/int64/uint8/uint16/uint32/uint64/float/double/bool/string/vec
  -string/int32/test.abc.Info/test.abc.Conflict/vec-test.xyz.Conflict/vec-double/map-test.abc.Info-i
  nt32/map-int32-test.abc.Info/map-int32-double/map-string-string
+@test.xyz.InfoX/vec-vec-vec-vec-vec-test.abc.Info/test.xyz.Conflict/test.abc.Conflict/map-int32-tes
  t.abc.Conflict/vec-vec-test.abc.Info/vec-vec-vec-test.abc.Info/vec-vec-vec-vec-vec-test.abc.Info/v
  ec-map-int16-test.abc.Info/map-vec-int32-test.abc.Info/map-test.abc.Info-vec-int32/map-vec-test.ab
  c.Info-vec-int32/vec-map-vec-test.abc.Info-vec-int32/map-string-string
+@test.xyz.TestDict/map-int8-int8/map-int16-int16/map-int32-int32/map-int64-int64/map-uint8-uint8/ma
  p-uint16-uint16/map-uint32-uint32/map-uint64-uint64/map-float-float/map-double-double/map-bool-boo
  l/map-string-string/map-int32-int32/map-test.abc.Custom-test.abc.Custom/map-string-string
+@test.xyz.TestList/vec-int8/vec-int16/vec-int32/vec-int64/vec-uint8/vec-uint16/vec-uint32/vec-uint6
  4/vec-float/vec-double/vec-bool/vec-string/vec-int32/vec-test.abc.Custom
+@test.xyz.TestNest/vec-map-string-test.abc.Custom/map-vec-string-vec-test.abc.Custom/vec-vec-vec-ve
  c-vec-test.abc.Custom
*/

