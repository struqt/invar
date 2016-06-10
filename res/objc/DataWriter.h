//
//  DataWriter.h
//  Created by WangKang on 6/8/16.
//

#ifndef DataWriter_h
#define DataWriter_h

@interface DataWriter : NSObject

+ (instancetype) Create;
+ (instancetype) CreateWithData:(NSMutableData*)data;

- (NSData*) data;

- (void) writeInt8   : (int8_t)    v;
- (void) writeInt16  : (int16_t)   v;
- (void) writeInt32  : (int32_t)   v;
- (void) writeInt64  : (int64_t)   v;
- (void) writeUInt8  : (uint8_t)   v;
- (void) writeUInt16 : (uint16_t)  v;
- (void) writeUInt32 : (uint32_t)  v;
- (void) writeUInt64 : (uint64_t)  v;
- (void) writeFloat  : (float_t)   v;
- (void) writeDouble : (double_t)  v;
- (void) writeBool   : (boolean_t) v;
- (void) writeString : (NSString*) v;

@end


#endif /* DataWriter_h */
