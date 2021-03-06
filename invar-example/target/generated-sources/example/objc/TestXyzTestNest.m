//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "TestXyzTestNest.h"

#define CRC32__ 0x6F0C2598
#define SIZE__  12L

@interface TestNest ()
{
    NSMutableArray      * _listDict; /* 0 &-vec<map<string,Test.Abc.Custom>> */
    NSMutableDictionary * _dictList; /* 1 &-map<vec<string>,vec<Test.Abc.Custom>> */
    NSMutableArray      * _list5d  ; /* 2 &-vec<vec<vec<vec<vec<Test.Abc.Custom>>>>> */
}
@end

@implementation TestNest

- (instancetype) init
{
    self = [super init];
    if (!self) { return self; }
    _listDict = [[NSMutableArray alloc] init];
    _dictList = [[NSMutableDictionary alloc] init];
    _list5d   = [[NSMutableArray alloc] init];
    return self;
}
/* TestNest::init */

- (void) dealloc
{
    if (_listDict) { _listDict = nil; }
    if (_dictList) { _dictList = nil; }
    if (_list5d  ) { _list5d   = nil; }
}
/* TestNest::dealloc */

- (id) copyWithZone:(nullable NSZone *)zone;
{
    id copy = [[[self class] allocWithZone:zone] init];
    DataWriter *writer = [DataWriter CreateWithData:[[NSMutableData alloc] initWithCapacity:[self byteSize]]];
    [self write:writer];
    [copy read:[DataReader CreateWithData:writer.data]];
    return copy;
}
/* TestNest::copyWithZone */

- (NSMutableArray      *) listDict { return _listDict; }
- (NSMutableDictionary *) dictList { return _dictList; }
- (NSMutableArray      *) list5d   { return _list5d  ; }

- (NSInteger)read:(const DataReader * const)r
{
    BOOL eof = false;
    uint32_t lenListDict = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iListDict = 0; iListDict < lenListDict; iListDict++) {
        NSMutableDictionary *n1 = [[NSMutableDictionary alloc] init]; //read.vec.head
        uint32_t lenN1 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
        for (uint32_t iN1 = 0; iN1 < lenN1; iN1++) {
            NSString *k2 = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
            Custom *v2 = [[Custom alloc] init];
            NSInteger v2Err = [v2 read:r]; if (v2Err != 0) { return v2Err; } if (eof) { return INVAR_ERR_DECODE_EOF; }
            [n1 setObject:v2 forKey:k2];
        }
        [_listDict addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenDictList = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iDictList = 0; iDictList < lenDictList; iDictList++) {
        NSMutableArray *k1 = [[NSMutableArray alloc] init]; //read.map.head
        uint32_t lenK1 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
        for (uint32_t iK1 = 0; iK1 < lenK1; iK1++) {
            NSString *n2 = [r readString:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
            [k1 addObject:n2];
        }
        NSMutableArray *v1 = [[NSMutableArray alloc] init]; //read.map.head
        uint32_t lenV1 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
        for (uint32_t iV1 = 0; iV1 < lenV1; iV1++) {
            Custom *n2 = [[Custom alloc] init];
            NSInteger n2Err = [n2 read:r]; if (n2Err != 0) { return n2Err; } if (eof) { return INVAR_ERR_DECODE_EOF; }
            [v1 addObject:n2];
        }
        [_dictList setObject:v1 forKey:k1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    uint32_t lenList5d = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
    for (uint32_t iList5d = 0; iList5d < lenList5d; iList5d++) {
        NSMutableArray *n1 = [[NSMutableArray alloc] init]; //read.vec.head
        uint32_t lenN1 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
        for (uint32_t iN1 = 0; iN1 < lenN1; iN1++) {
            NSMutableArray *n2 = [[NSMutableArray alloc] init]; //read.vec.head
            uint32_t lenN2 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
            for (uint32_t iN2 = 0; iN2 < lenN2; iN2++) {
                NSMutableArray *n3 = [[NSMutableArray alloc] init]; //read.vec.head
                uint32_t lenN3 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
                for (uint32_t iN3 = 0; iN3 < lenN3; iN3++) {
                    NSMutableArray *n4 = [[NSMutableArray alloc] init]; //read.vec.head
                    uint32_t lenN4 = [r readUInt32:&eof]; if (eof) { return INVAR_ERR_DECODE_EOF; }
                    for (uint32_t iN4 = 0; iN4 < lenN4; iN4++) {
                        Custom *n5 = [[Custom alloc] init];
                        NSInteger n5Err = [n5 read:r]; if (n5Err != 0) { return n5Err; } if (eof) { return INVAR_ERR_DECODE_EOF; }
                        [n4 addObject:n5];
                    }
                    [n3 addObject:n4];
                }
                [n2 addObject:n3];
            }
            [n1 addObject:n2];
        }
        [_list5d addObject:n1];
    } if (eof) { return INVAR_ERR_DECODE_EOF; }
    return INVAR_ERR_NONE;
}
/* TestNest::read(...) */

- (NSInteger)write:(DataWriter *)w
{
    [w writeUInt32:(uint32_t)[_listDict count]];
    for (id n1 in _listDict) {
        [w writeUInt32:(uint32_t)[n1 count]];
        for (id k2 in n1) {
            [w writeString:k2];
            Custom *v2 = [n1 objectForKey:k2];
            [v2 write:w];
        }
    }
    [w writeUInt32:(uint32_t)[_dictList count]];
    for (id k1 in _dictList) {
        [w writeUInt32:(uint32_t)[k1 count]];
        for (id n2 in k1) {
            [w writeString:n2];
        }
        NSMutableArray *v1 = [_dictList objectForKey:k1];/*write.map.head.v*/
        [w writeUInt32:(uint32_t)[v1 count]];
        for (id n2 in v1) {
            [n2 write:w];
        }
    }
    [w writeUInt32:(uint32_t)[_list5d count]];
    for (id n1 in _list5d) {
        [w writeUInt32:(uint32_t)[n1 count]];
        for (id n2 in n1) {
            [w writeUInt32:(uint32_t)[n2 count]];
            for (id n3 in n2) {
                [w writeUInt32:(uint32_t)[n3 count]];
                for (id n4 in n3) {
                    [w writeUInt32:(uint32_t)[n4 count]];
                    for (id n5 in n4) {
                        [n5 write:w];
                    }
                }
            }
        }
    }
    return 0;
}
/* TestNest::write */

- (NSUInteger)byteSize
{
    NSUInteger size = SIZE__;
    size += sizeof(uint32_t);
    for (id n1 in _listDict) {
        size += sizeof(uint32_t);
        for (id k2 in n1) {
            size += [k2 length];
            Custom *v2 = [n1 objectForKey:k2];
            size += [v2 byteSize];
        }
    }
    size += sizeof(uint32_t);
    for (id k1 in _dictList) {
        size += sizeof(uint32_t);
        for (id n2 in k1) {
            size += [n2 length];
        }
        NSMutableArray *v1 = [_dictList objectForKey:k1];/*size.map.head.v*/
        size += sizeof(uint32_t);
        for (id n2 in v1) {
            size += [n2 byteSize];
        }
    }
    size += sizeof(uint32_t);
    for (id n1 in _list5d) {
        size += sizeof(uint32_t);
        for (id n2 in n1) {
            size += sizeof(uint32_t);
            for (id n3 in n2) {
                size += sizeof(uint32_t);
                for (id n4 in n3) {
                    size += sizeof(uint32_t);
                    for (id n5 in n4) {
                        size += [n5 byteSize];
                    }
                }
            }
        }
    }
    return size;
}
/* TestNest::byteSize */

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
    BOOL listDictExists = (nil != _listDict && [_listDict count] > 0);
    if (listDictExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"listDict"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger listDictSize = (nil == _listDict ? 0 : [_listDict count]);
        if (listDictSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int listDictIdx = 0;
            for (id n1 in _listDict) {/* vec.for: _listDict */
                ++listDictIdx;
                NSUInteger n1Size = (nil == n1 ? 0 : [n1 count]);
                if (n1Size > 0) {
                    [s appendString:LINE_FEED_S]; [s appendString:LEFT_CURLY_S];
                    int n1Idx = 0;
                    for (id k2 in n1) { /* map.for: n1 */
                        ++n1Idx;
                        [s appendString:QUOTATION_S]; [s appendString:k2]; [s appendString:QUOTATION_S]; [s appendString:COLON_S]; /* nest.k.string */
                        id v2 = [n1 objectForKey:k2];
                        [v2 writeJSON:s]; /* nest.v */
                        if (n1Idx != n1Size) { [s appendString:COMMA_S]; }
                    }
                    [s appendString:RIGHT_CURLY_S];
                }
                if (listDictIdx != listDictSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    BOOL dictListExists = (nil != _dictList && [_dictList count] > 0);
    if (comma && dictListExists) { [s appendString:comma]; comma = nil; }
    if (dictListExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"dictList"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger dictListSize = (nil == _dictList ? 0 : [_dictList count]);
        if (dictListSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_CURLY_S];
            int dictListIdx = 0;
            for (id k1 in _dictList) { /* map.for: _dictList */
                ++dictListIdx;
                NSUInteger k1Size = (nil == k1 ? 0 : [k1 count]);
                if (k1Size > 0) {
                    [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
                    int k1Idx = 0;
                    for (id n2 in k1) {/* vec.for: k1 */
                        ++k1Idx;
                        [s appendString:QUOTATION_S]; [s appendString:n2]; [s appendString:QUOTATION_S];
                        if (k1Idx != k1Size) { [s appendString:COMMA_S]; }
                    }
                    [s appendString:RIGHT_SQUARE_S];
                }
                NSMutableArray *v1 = [_dictList objectForKey:k1];/*map.head.v*/
                NSUInteger v1Size = (nil == v1 ? 0 : [v1 count]);
                if (v1Size > 0) {
                    [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
                    int v1Idx = 0;
                    for (id n2 in v1) {/* vec.for: v1 */
                        ++v1Idx;
                        [n2 writeJSON:s];
                        if (v1Idx != v1Size) { [s appendString:COMMA_S]; }
                    }
                    [s appendString:RIGHT_SQUARE_S];
                }
                if (dictListIdx != dictListSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_CURLY_S];
        } comma = COMMA_S;
    }
    BOOL list5dExists = (nil != _list5d && [_list5d count] > 0);
    if (comma && list5dExists) { [s appendString:comma]; comma = nil; }
    if (list5dExists) {
        [s appendString:QUOTATION_S]; [s appendString:@"list5d"]; [s appendString:QUOTATION_S]; [s appendString:COLON_S];
        NSUInteger list5dSize = (nil == _list5d ? 0 : [_list5d count]);
        if (list5dSize > 0) {
            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
            int list5dIdx = 0;
            for (id n1 in _list5d) {/* vec.for: _list5d */
                ++list5dIdx;
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
                                        NSUInteger n4Size = (nil == n4 ? 0 : [n4 count]);
                                        if (n4Size > 0) {
                                            [s appendString:LINE_FEED_S]; [s appendString:LEFT_SQUARE_S];
                                            int n4Idx = 0;
                                            for (id n5 in n4) {/* vec.for: n4 */
                                                ++n4Idx;
                                                [n5 writeJSON:s];
                                                if (n4Idx != n4Size) { [s appendString:COMMA_S]; }
                                            }
                                            [s appendString:RIGHT_SQUARE_S];
                                        }
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
                if (list5dIdx != list5dSize) { [s appendString:COMMA_S]; }
            }
            [s appendString:RIGHT_SQUARE_S];
        } comma = COMMA_S;
    }
    [s appendString:RIGHT_CURLY_S]; [s appendString:LINE_FEED_S];
}
/* TestNest::writeJSON */

@end /* @implementation TestNest */
/*
1@test.xyz.TestNest/vec-map-string-test.abc.Custom/map-vec-string-vec-test.abc.Custom/vec-vec-vec-ve
  c-vec-test.abc.Custom
+@test.abc.Custom/int32/test.abc.TestBasic/test.xyz.Conflict/test.abc.Conflict/vec-test.abc.Custom/i
  nt32/string/string/test.abc.Custom/test.abc.Custom/string
*/

