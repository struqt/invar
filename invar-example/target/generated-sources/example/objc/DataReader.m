//===---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===//
///*
#if ! __has_feature(objc_arc)
#error This file must be compiled with ARC. Either turn on ARC for the project or use -fobjc-arc flag
#endif //*/

#import "Invar.h"
#import "DataReader.h"

@interface DataReader ()
{
    CFByteOrder _byteOrder;
    const char *_bytes;
    NSUInteger  _bytesLen;
    NSUInteger  _bytesPos;
}
@end

@implementation DataReader

static const CFByteOrder ByteOrderDeftR = CFByteOrderBigEndian;

+ (instancetype) CreateWithBytes:(const void * const)bytes andLength:(NSUInteger)length
{
    return [[DataReader alloc] initWithBytes:bytes andLength:length];
}

+ (instancetype) CreateWithData:(const NSData * const)data
{
    if (!data) { return nil; }
    return [[DataReader alloc] initWithBytes:data.bytes andLength:data.length];
}

+ (instancetype) CreateWithData:(const NSData * const)data andOffset:(NSUInteger)offset;
{
    if (!data) { return nil; }
    return [[DataReader alloc] initWithBytes:data.bytes + offset andLength:data.length];
}

- (instancetype) initWithBytes:(const void * const)bytes andLength:(NSUInteger)len
{
    self = [super init];
    if (!self) {
        return self;
    }
    _bytes = bytes;
    _bytesLen = len;
    _bytesPos = 0;
    _byteOrder = ByteOrderDeftR;
    return self;
}

- (void) dealloc
{
    _bytes = NULL;
    _bytesLen = 0;
    _bytesPos = 0;
}

- (instancetype) rewind
{
    _bytesPos = 0;
    return self;
}

- (instancetype) bigEndian
{
    _byteOrder = CFByteOrderBigEndian;
    return self;
}

- (instancetype) littleEndian
{
    _byteOrder = CFByteOrderLittleEndian;
    return self;
}

- (int8_t) readInt8:(BOOL*)eof
{
    if (![self checkAvailable:1]) { *eof = YES; }
    if (*eof) { return 0; }
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(int8_t);
    return *(int8_t*)p;
}

- (int16_t) readInt16:(BOOL*)eof
{
    if (![self checkAvailable:2]) { *eof = YES; }
    if (*eof) { return 0; }
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(int16_t);
    if (CFByteOrderBigEndian == _byteOrder) {
        return CFSwapInt16HostToBig(*(int16_t*)p);
    } else {
        return *(int16_t*)p;
    }
}

- (int32_t) readInt32:(BOOL*)eof
{
    if (![self checkAvailable:4]) { *eof = YES; }
    if (*eof) { return 0; }
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(int32_t);
    if (CFByteOrderBigEndian == _byteOrder) {
        return CFSwapInt32HostToBig(*(int32_t*)p);
    } else {
        return *(int32_t*)p;
    }
}

- (int64_t) readInt64:(BOOL*)eof
{
    if (![self checkAvailable:8]) { *eof = YES; }
    if (*eof) { return 0; }
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(int64_t);
    if (CFByteOrderBigEndian == _byteOrder) {
        return CFSwapInt64HostToBig(*(int64_t*)p);
    } else {
        return *(int64_t*)p;
    }
}

- (uint8_t) readUInt8:(BOOL*)eof
{
    if (![self checkAvailable:1]) { *eof = YES; }
    if (*eof) { return 0; }
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(uint8_t);
    return *(uint8_t*)p;
}

- (uint16_t) readUInt16:(BOOL*)eof
{
    if (![self checkAvailable:2]) { *eof = YES; }
    if (*eof) { return 0; }
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(uint16_t);
    if (CFByteOrderBigEndian == _byteOrder) {
        return CFSwapInt16HostToBig(*(uint16_t*)p);
    } else {
        return *(uint16_t*)p;
    }
}

- (uint16_t) peekUInt16:(BOOL *)eof
{
    if (![self checkAvailable:2]) { *eof = YES; }
    if (*eof) { return 0; }
    const char *p = _bytes + _bytesPos;
    if (CFByteOrderBigEndian == _byteOrder) {
        return CFSwapInt16HostToBig(*(uint16_t*)p);
    } else {
        return *(uint16_t*)p;
    }
}

- (uint32_t) readUInt32:(BOOL*)eof
{
    if (![self checkAvailable:4]) { *eof = YES; }
    if (*eof) { return 0; }
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(uint32_t);
    if (CFByteOrderBigEndian == _byteOrder) {
        return CFSwapInt32HostToBig(*(uint32_t*)p);
    } else {
        return *(uint32_t*)p;
    }
}

- (uint64_t) readUInt64:(BOOL*)eof
{
    if (![self checkAvailable:8]) { *eof = YES; }
    if (*eof) { return 0; }
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(uint64_t);
    if (CFByteOrderBigEndian == _byteOrder) {
        return CFSwapInt64HostToBig(*(uint64_t*)p);
    } else {
        return *(uint64_t*)p;
    }
}

- (float_t) readFloat:(BOOL*)eof
{
    uint32_t i = [self readUInt32:eof];
    if (*eof) { return 0; }
    return invar_decode_float32(i);
}

- (double_t) readDouble:(BOOL*)eof
{
    uint64_t i = [self readUInt64:eof];
    if (*eof) { return 0; }
    return invar_decode_float64(i);
}

- (boolean_t) readBool:(BOOL*)eof
{
    if (![self checkAvailable:1]) { *eof = YES; }
    if (*eof) { return 0; }
    const char *p = _bytes + _bytesPos;
    _bytesPos += sizeof(uint8_t);
    return *(uint8_t*)p == 0x01;
}

- (NSString*) readString:(BOOL*)eof
{
    if (![self checkAvailable:2]) { *eof = YES; }
    if (*eof) { return nil; }
    NSUInteger len = [self readUInt16:eof];
    if (len == 0 || ![self checkAvailable:len]) {
        return @"";
    }
    const char *p = _bytes + _bytesPos;
    _bytesPos += len;
    return [[NSString alloc] initWithBytes:p length:len encoding:NSUTF8StringEncoding];
}

- (BOOL) checkAvailable:(NSUInteger)count
{
    if (_bytes == NULL) { return NO; }
    if (_bytesPos + count > _bytesLen) { return NO; }
    return YES;
}

@end
