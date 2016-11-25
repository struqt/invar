//*==---------------------------*  Obj-C  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------==*//

#import "InvarRuntime.h"

@implementation InvarClient

+ (void) handleResponse:(NSData *)dataResp
                  onYes:(RecvResponse)blockResp
                  onErr:(HandleError)blockErr
{
    BOOL eof = NO;
    DataReader *reader = [DataReader CreateWithData:dataResp];
    uint16_t protocErr = [reader readUInt16:&eof];
    uint16_t protocId = 0;
    if (eof) { protocErr = INVAR_ERR_DECODE_EOF; }
    if (protocErr != INVAR_ERR_NONE) {
        protocId = [reader peekUInt16:&eof];
        if (blockErr) {
            blockErr(protocErr, protocId);
        }
    } else {
        id<ProtocResponse> resp =
            [InvarRuntime HandleProtocAsClient:reader Protoc:&protocId Error:&protocErr];
        if (protocErr == INVAR_ERR_NONE) {
            if (blockResp) {
                blockResp(resp);
            }
        } else {
            if (blockErr) {
                blockErr(protocErr, protocId);
            }
        }
    }
}

@end
