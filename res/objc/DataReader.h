//
//  DataReader.h
//  Created by WangKang on 6/8/16.
//

#ifndef DataReader_h
#define DataReader_h

@interface DataReader : NSObject

+ (instancetype) CreateWithBytes:(const void*)bytes andLength:(NSUInteger)len;
+ (instancetype) CreateWithData:(NSData*)data;
+ (instancetype) CreateWithData:(NSData*)data andOffset:(NSUInteger)offset;

- (int8_t)    readInt8   : (boolean_t *)eof;
- (int16_t)   readInt16  : (boolean_t *)eof;
- (int32_t)   readInt32  : (boolean_t *)eof;
- (int64_t)   readInt64  : (boolean_t *)eof;
- (uint8_t)   readUInt8  : (boolean_t *)eof;
- (uint16_t)  readUInt16 : (boolean_t *)eof;
- (uint32_t)  readUInt32 : (boolean_t *)eof;
- (uint64_t)  readUInt64 : (boolean_t *)eof;
- (float_t)   readFloat  : (boolean_t *)eof;
- (double_t)  readDouble : (boolean_t *)eof;
- (boolean_t) readBool   : (boolean_t *)eof;
- (NSString*) readString : (boolean_t *)eof;

@end

#endif /* DataReader_h */
