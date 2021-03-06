//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#import "Invar.h"
#import "InvarRuntime.h"

typedef union { unsigned char c[2]; uint16_t i; } invar_union_uint16_chars_t;
typedef union { float_t       f;    uint32_t i; } invar_union_float32_int_t;
typedef union { double_t      f;    uint64_t i; } invar_union_float64_int_t;

boolean_t invar_is_big_endian (void)
{
    const invar_union_uint16_chars_t u = { .i = 0x0102 };
    return 0x01 == u.c[0];
}

float_t invar_decode_float32 (uint32_t x)
{
    const invar_union_float32_int_t u = { .i = x };
    return u.f;
}

double_t invar_decode_float64 (uint64_t x)
{
    const invar_union_float64_int_t u = { .i = x };
    return u.f;
}

uint32_t invar_encode_float32 (float_t x)
{
    const invar_union_float32_int_t u = { .f = x };
    return u.i;
}

uint64_t invar_encode_float64 (double_t x)
{
    const invar_union_float64_int_t u = { .f = x };
    return u.i;
}

void handle_no_reply (const void * const input, int32_t length, BOOL server)
{
    assert(length >= 0);
    if (NULL == input) {
        NSLog(@"The input pointer is NULL");
        return;
    }
    if (0 == length) {
        NSLog(@"The input bytes length is 0");
        return;
    }
    uint16_t req = 0;
    uint16_t code = INVAR_ERR_PROTOC_UNHANDLED;
    id reader = [DataReader CreateWithBytes:input andLength:length];
    if (server) {
        [[InvarRuntime class] HandleProtocAsServer:reader Protoc:&req Error:&code];
    } else {
        [[InvarRuntime class] HandleProtocAsClient:reader Protoc:&req Error:&code];
    }
}

ResponseBytes handle_with_reply (const void * const input, int32_t length, BOOL server)
{
    assert(length >= 0);
    uint16_t req = 0;
    uint16_t code = INVAR_ERR_PROTOC_UNHANDLED;
    ResponseBytes result;
    result.bytes = NULL;
    result.length = 0;
    result.request = 0;
    result.response = 0;
    if (NULL == input) {
        NSLog(@"The input pointer is NULL.");
        result.error = INVAR_ERR_INVALID_REQ;
        return result;
    }
    if (0 == length) {
        NSLog(@"The input bytes length is 0.");
        result.error = INVAR_ERR_INVALID_REQ;
        return result;
    }
    id reader = [DataReader CreateWithBytes:input andLength:length];
    id resp = nil;
    if (server) {
        resp = [[InvarRuntime class] HandleProtocAsServer:reader Protoc:&req Error:&code];
    } else {
        resp = [[InvarRuntime class] HandleProtocAsClient:reader Protoc:&req Error:&code];
    }
    result.request = req;
    if (!resp) {
        result.error = code;
        return result;
    }
    result.response = [resp protocId];
    DataWriter *writer = [DataWriter Create];
    [resp write:writer];
    NSData *data = [writer data];
    if ([data length] > INT32_MAX) {
        result.error = INVAR_ERR_SIZE_TOO_LONG;
        return result;
    }
    result.error = [resp protocError];
    result.bytes = [data bytes];
    result.length = (int32_t)[data length];
    return result;
}

ResponseBytes HandleRequest2S (const void * const input, int32_t length)
{
    return handle_with_reply(input, length, YES);
}
ResponseBytes HandleRequest2C (const void * const input, int32_t length)
{
    return handle_with_reply(input, length, NO);
}

void HandleResponse2S (const void * const input, int32_t length)
{
    handle_no_reply(input, length, YES);
}
void HandleResponse2C (const void * const input, int32_t length)
{
    handle_no_reply(input, length, NO);
}

void HandleNotify2S (const void * const input, int32_t length)
{
    handle_no_reply(input, length, YES);
}
void HandleNotify2C (const void * const input, int32_t length)
{
    handle_no_reply(input, length, NO);
}
