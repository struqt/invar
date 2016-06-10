//
//  DataReader.m
//  Created by WangKang on 6/8/16.
//

#import "DataReader.h"

@interface DataReader ()
{
    const char *_bytes;
    NSUInteger  _bytesLen;
    NSUInteger  _bytesPos;
}

- (instancetype)initWithBytes:(const void*)bytes andLength:(NSUInteger)len;
- (BOOL) checkAvailable:(NSUInteger)count;

@end


@implementation DataReader

+ (instancetype) CreateWithBytes:(const void*)bytes andLength:(NSUInteger)length
{
    return [[DataReader alloc] initWithBytes:bytes andLength:length];
}

+ (instancetype) CreateWithData:(NSData*)data
{
    if (!data) { return nil; }
    return [[DataReader alloc] initWithBytes:data.bytes andLength:data.length];
}

+ (instancetype) CreateWithData:(NSData*)data andOffset:(NSUInteger)offset;
{
    if (!data) { return nil; }
    return [[DataReader alloc] initWithBytes:data.bytes + offset andLength:data.length];
}

- (instancetype)initWithBytes:(const void*)bytes andLength:(NSUInteger)len
{
    self = [super init];
    if (!self) {
        return self;
    }
    _bytes = bytes;
    _bytesLen = len;
    _bytesPos = 0;
    return self;
}

- (int8_t) readInt8:(boolean_t*)eof
{
    if (![self checkAvailable:1]){
        *eof = true;
        return 0;
    }
    *eof = false;
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(int8_t);
    return *(int8_t*)p;
}

- (int16_t) readInt16:(boolean_t*)eof
{
    if (![self checkAvailable:2]){
        *eof = true;
        return 0;
    }
    *eof = false;
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(int16_t);
    return *(int16_t*)p;
}

- (int32_t) readInt32:(boolean_t*)eof
{
    if (![self checkAvailable:4]){
        *eof = true;
        return 0;
    }
    *eof = false;
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(int32_t);
    return *(int32_t*)p;
}

- (int64_t) readInt64:(boolean_t*)eof
{
    if (![self checkAvailable:8]){
        *eof = true;
        return 0;
    }
    *eof = false;
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(int64_t);
    return *(int64_t*)p;
}

- (uint8_t) readUInt8:(boolean_t*)eof
{
    if (![self checkAvailable:1]){
        *eof = true;
        return 0;
    }
    *eof = false;
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(uint8_t);
    return *(uint8_t*)p;
}

- (uint16_t) readUInt16:(boolean_t*)eof
{
    if (![self checkAvailable:2]){
        *eof = true;
        return 0;
    }
    *eof = false;
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(uint16_t);
    return *(uint16_t*)p;
}

- (uint32_t) readUInt32:(boolean_t*)eof
{
    if (![self checkAvailable:4]){
        *eof = true;
        return 0;
    }
    *eof = false;
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(uint32_t);
    return *(uint32_t*)p;
}

- (uint64_t) readUInt64:(boolean_t*)eof
{
    if (![self checkAvailable:8]){
        *eof = true;
        return 0;
    }
    *eof = false;
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(uint64_t);
    return *(uint64_t*)p;
}

- (float_t) readFloat:(boolean_t*)eof
{
    if (![self checkAvailable:4]){
        *eof = true;
        return 0.0f;
    }
    *eof = false;
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(float_t);
    return *(float_t*)p;
}

- (double_t) readDouble:(boolean_t*)eof
{
    if (![self checkAvailable:8]){
        *eof = true;
        return 0.0;
    }
    *eof = false;
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(double_t);
    return *(double_t*)p;
}

- (boolean_t) readBool:(boolean_t*)eof
{
    if (![self checkAvailable:1]){
        *eof = true;
        return false;
    }
    *eof = false;
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(uint8_t);
    return *(uint8_t*)p == 0x01;
}

- (NSString*) readString:(boolean_t*)eof
{
    NSUInteger len = [self readUInt32:eof];
    if (*eof == true) {
        return nil;
    }
    if (len == 0 || ![self checkAvailable:len]) {
        return  [[NSString alloc] initWithString:@""];
    }
    const char *p = _bytes + _bytesPos;
    return [[NSString alloc] initWithBytes:p length:len encoding:NSUTF8StringEncoding];
}

- (BOOL) checkAvailable:(NSUInteger)count
{
    if (_bytesPos + count >= _bytesLen) {
        return NO;
    }
    return YES;
}


@end
