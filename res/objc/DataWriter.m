//
//  DataWriter.m
//  Created by WangKang on 6/8/16.
//

#import "DataWriter.h"

@interface DataWriter ()
{
    NSMutableData* _data;
}
- (instancetype)init;
- (instancetype)initWithData:(NSMutableData*)data;
@end

@implementation DataWriter

+ (instancetype) Create
{
    return [[DataWriter alloc] init];
}

+ (instancetype) CreateWithData:(NSMutableData*)data
{
    return [[DataWriter alloc] initWithData:data];
}

- (instancetype)init
{
    self = [super init];
    if (!self) {
        return nil;
    }
    _data = [[NSMutableData alloc] initWithCapacity:128];
    return self;
}

- (instancetype)initWithData:(NSMutableData*)data
{
    self = [super init];
    if (!self || !data) {
        return nil;
    }
    _data = data;
    return self;
}

- (NSData*)data
{
    return _data;
}

- (void) writeInt8:(int8_t)v
{
    [_data appendBytes:&v length:sizeof(int8_t)];
}

- (void) writeInt16:(int16_t)v
{
    [_data appendBytes:&v length:sizeof(int16_t)];
}

- (void) writeInt32:(int32_t)v
{
    [_data appendBytes:&v length:sizeof(int32_t)];
}

- (void) writeInt64:(int64_t)v
{
    [_data appendBytes:&v length:sizeof(int64_t)];
}

- (void) writeUInt8:(uint8_t)v
{
    [_data appendBytes:&v length:sizeof(uint8_t)];
}

- (void) writeUInt16:(uint16_t)v
{
    [_data appendBytes:&v length:sizeof(uint16_t)];
}

- (void) writeUInt32:(uint32_t)v
{
    [_data appendBytes:&v length:sizeof(uint32_t)];
}

- (void) writeUInt64:(uint64_t)v
{
    [_data appendBytes:&v length:sizeof(uint64_t)];
}

- (void) writeFloat:(float_t)v
{
    [_data appendBytes:&v length:sizeof(float_t)];
}

- (void) writeDouble:(double_t)v
{
    [_data appendBytes:&v length:sizeof(double_t)];
}

- (void) writeBool:(boolean_t)v
{
    [self writeUInt8:(v ? 0x01 : 0x00)];
}

- (void) writeString:(NSString*)v
{
    NSData *data = [v dataUsingEncoding:NSUTF8StringEncoding];
    NSUInteger len = data.length;
    [_data appendBytes:&len length:sizeof(NSUInteger)];
    [_data appendData:data];
}


@end
