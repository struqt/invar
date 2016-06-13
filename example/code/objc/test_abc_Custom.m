//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "test_abc_Custom.h"

#define CRC32 0x34A39940

@interface Custom ()
{
    Gender              _x       ; /* 0 test.abc.Gender */
    TestBasic         * _test    ; /* 1 test.abc.TestBasic */
    test_xyz_Conflict * _xyz     ; /* 2 test.xyz.Conflict */
    test_abc_Conflict * _abc     ; /* 3 test.abc.Conflict */
    NSMutableArray    * _children; /* 4 vec<test.abc.Custom> */
    int32_t             _noSetter; /* 5 int32 */
    NSString          * _useRef  ; /* 6 string */
    NSString          * _usePtr  ; /* 7 string */
    Custom            * _prev    ; /* 8 test.abc.Custom */
    Custom            * _next    ; /* 9 test.abc.Custom */
    NSString          * _emptyDoc; /* 10 string */
}
@end

@implementation Custom

- (instancetype) init
{
    self = [super init];
    if (!self) { return self; }
    _x        = NONE;
    _test     = [[TestBasic alloc] init];
    _xyz      = [[test_xyz_Conflict alloc] init];
    _abc      = [[test_abc_Conflict alloc] init];
    _children = [[NSMutableArray alloc] init];
    _noSetter = -1;
    _useRef   = @"";
    _usePtr   = nil;
    _prev     = nil;
    _next     = nil;
    _emptyDoc = @"";
    return self;
}
/* Custom::init */

- (void) dealloc
{
    if (_test    ) { _test     = nil; }
    if (_xyz     ) { _xyz      = nil; }
    if (_abc     ) { _abc      = nil; }
    if (_children) { _children = nil; }
    if (_useRef  ) { _useRef   = nil; }
    if (_usePtr  ) { _usePtr   = nil; }
    if (_prev    ) { _prev     = nil; }
    if (_next    ) { _next     = nil; }
    if (_emptyDoc) { _emptyDoc = nil; }
}
/* Custom::dealloc */

- (id) copyWithZone:(nullable NSZone *)zone;
{
    id copy = [[[self class] allocWithZone:zone] init];
    DataWriter *writer = [DataWriter Create];
    [self write:writer];
    [copy read:[DataReader CreateWithData:writer.data]];
    return copy;
}
/* Custom::copyWithZone */

- (Gender             ) x        { return _x       ; }
- (TestBasic         *) test     { return _test    ; }
- (test_xyz_Conflict *) xyz      { return _xyz     ; }
- (test_abc_Conflict *) abc      { return _abc     ; }
- (NSMutableArray    *) children { return _children; }
- (int32_t            ) noSetter { return _noSetter; }
- (NSString          *) useRef   { return _useRef  ; }
- (NSString          *) usePtr   { return _usePtr  ; }
- (Custom            *) prev     { return _prev    ; }
- (Custom            *) next     { return _next    ; }
- (NSString          *) emptyDoc { return _emptyDoc; }

- (Custom *) setX        : (Gender             )v { _x        = v; return self; }
- (Custom *) setTest     : (TestBasic         *)v { _test     = v; return self; }
- (Custom *) setXyz      : (test_xyz_Conflict *)v { _xyz      = v; return self; }
- (Custom *) setAbc      : (test_abc_Conflict *)v { _abc      = v; return self; }
- (Custom *) setUseRef   : (NSString          *)v { _useRef   = v; return self; }
- (Custom *) setUsePtr   : (NSString          *)v { _usePtr   = v; return self; }
- (Custom *) setPrev     : (Custom            *)v { _prev     = v; return self; }
- (Custom *) setNext     : (Custom            *)v { _next     = v; return self; }
- (Custom *) setEmptyDoc : (NSString          *)v { _emptyDoc = v; return self; }

- (NSInteger)read:(DataReader *)r
{
    BOOL eof = false;
    _x = (Gender)[r readInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    NSInteger testErr = [_test read:r]; if (testErr != 0) { return testErr; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    NSInteger xyzErr = [_xyz read:r]; if (xyzErr != 0) { return xyzErr; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    NSInteger abcErr = [_abc read:r]; if (abcErr != 0) { return abcErr; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenChildren = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iChildren = 0; iChildren < lenChildren; iChildren++) {
        Custom *n1 = [[Custom alloc] init];
        NSInteger n1Err = [n1 read:r]; if (n1Err != 0) { return n1Err; } if (eof) { return INVAR_ERR_DECODE_EOF; }
        [_children addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    _noSetter = [r readInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    _useRef = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t usePtrExists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == usePtrExists) {
        _usePtr = [r readString:&eof];
    }
    else if (0x00 == usePtrExists) { _usePtr = nil; }
    else { return INVAR_ERR_DECODE_STRING_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t prevExists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == prevExists) {
        if (_prev == nil) { _prev = [[Custom alloc] init]; }
        NSInteger prevErr = [_prev read:r]; if (prevErr != 0) { return prevErr; }
    }
    else if (0x00 == prevExists) { _prev = nil; }
    else { return INVAR_ERR_DECODE_STRUCT_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    int8_t nextExists = [r readInt8:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    if (0x01 == nextExists) {
        if (_next == nil) { _next = [[Custom alloc] init]; }
        NSInteger nextErr = [_next read:r]; if (nextErr != 0) { return nextErr; }
    }
    else if (0x00 == nextExists) { _next = nil; }
    else { return INVAR_ERR_DECODE_STRUCT_P; } if (eof) { return INVAR_ERR_DECODE_EOF; }
    _emptyDoc = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    return INVAR_ERR_NONE;
}
/* Custom::read(...) */

- (NSInteger)write:(DataWriter *)w
{
    [w writeInt32:_x];
    [_test write:w];
    [_xyz write:w];
    [_abc write:w];
    [w writeUInt32:(uint32_t)[_children count]];
    for (id n1 in _children) {
        [n1 write:w];
    }
    [w writeInt32:_noSetter];
    [w writeString:_useRef];
    if (_usePtr != nil) { [w writeInt8:0x01]; [w writeString:_usePtr]; }
    else { [w writeInt8:0x00]; }
    if (_prev != nil) { [w writeInt8:0x01]; [_prev write:w]; }
    else { [w writeInt8:0x00]; }
    if (_next != nil) { [w writeInt8:0x01]; [_next write:w]; }
    else { [w writeInt8:0x00]; }
    [w writeString:_emptyDoc];
    return 0;
}
/* Custom::write */

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
    [s appendString:@"\""]; [s appendString:@"x"]; [s appendString:@"\""]; [s appendString:@":"];
    comma = @","; [s appendFormat:@"%@", @(_x)];
    BOOL testExists = (nil != _test);
    if (comma && testExists) { [s appendString:comma]; comma = nil; }
    if (testExists) {
        [s appendString:@"\""]; [s appendString:@"test"]; [s appendString:@"\""]; [s appendString:@":"];
        comma = @","; [_test writeJSON:s];
    }
    BOOL xyzExists = (nil != _xyz);
    if (comma && xyzExists) { [s appendString:comma]; comma = nil; }
    if (xyzExists) {
        [s appendString:@"\""]; [s appendString:@"xyz"]; [s appendString:@"\""]; [s appendString:@":"];
        comma = @","; [_xyz writeJSON:s];
    }
    BOOL abcExists = (nil != _abc);
    if (comma && abcExists) { [s appendString:comma]; comma = nil; }
    if (abcExists) {
        [s appendString:@"\""]; [s appendString:@"abc"]; [s appendString:@"\""]; [s appendString:@":"];
        comma = @","; [_abc writeJSON:s];
    }
    BOOL childrenExists = (nil != _children && [_children count] > 0);
    if (comma && childrenExists) { [s appendString:comma]; comma = nil; }
    if (childrenExists) {
        [s appendString:@"\""]; [s appendString:@"children"];
        [s appendString:@"\""]; [s appendString:@":"]; comma = @","; }
    NSUInteger childrenSize = (nil == _children ? 0 : [_children count]);
    if (childrenSize > 0) {
        [s appendString:@"\n"]; [s appendString:@"["];
        int childrenIdx = 0;
        for (id n1 in _children) {/* vec.for: _children */
            ++childrenIdx;
            [n1 writeJSON:s];
            if (childrenIdx != childrenSize) { [s appendString:@","]; }
        }
        [s appendString:@"]"];
    }
    if (comma) { [s appendString:comma]; comma = nil; }
    [s appendString:@"\""]; [s appendString:@"noSetter"]; [s appendString:@"\""]; [s appendString:@":"];
    comma = @","; [s appendFormat:@"%@", @(_noSetter)];
    BOOL useRefExists = (nil != _useRef && ![@"" isEqual:_useRef]);
    if (comma && useRefExists) { [s appendString:comma]; comma = nil; }
    if (useRefExists) {
        [s appendString:@"\""]; [s appendString:@"useRef"]; [s appendString:@"\""]; [s appendString:@":"];
        comma = @","; [s appendString:@"\""]; [s appendString:_useRef]; [s appendString:@"\""];
    }
    BOOL usePtrExists = (nil != _usePtr && ![@"" isEqual:_usePtr]);
    if (comma && usePtrExists) { [s appendString:comma]; comma = nil; }
    if (usePtrExists) {
        [s appendString:@"\""]; [s appendString:@"usePtr"]; [s appendString:@"\""]; [s appendString:@":"];
        comma = @","; [s appendString:@"\""]; [s appendString:_usePtr]; [s appendString:@"\""];
    }
    BOOL prevExists = (nil != _prev);
    if (comma && prevExists) { [s appendString:comma]; comma = nil; }
    if (prevExists) {
        [s appendString:@"\""]; [s appendString:@"prev"]; [s appendString:@"\""]; [s appendString:@":"];
        comma = @","; [_prev writeJSON:s];
    }
    BOOL nextExists = (nil != _next);
    if (comma && nextExists) { [s appendString:comma]; comma = nil; }
    if (nextExists) {
        [s appendString:@"\""]; [s appendString:@"next"]; [s appendString:@"\""]; [s appendString:@":"];
        comma = @","; [_next writeJSON:s];
    }
    BOOL emptyDocExists = (nil != _emptyDoc && ![@"" isEqual:_emptyDoc]);
    if (comma && emptyDocExists) { [s appendString:comma]; comma = nil; }
    if (emptyDocExists) {
        [s appendString:@"\""]; [s appendString:@"emptyDoc"]; [s appendString:@"\""]; [s appendString:@":"];
        comma = @","; [s appendString:@"\""]; [s appendString:_emptyDoc]; [s appendString:@"\""];
    }
    [s appendString:@"}"]; [s appendString:@"\n"];
}
/* Custom::writeJSON */

@end /* @implementation Custom */

