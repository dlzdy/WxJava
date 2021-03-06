package me.chanjar.weixin.cp.bean;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.chanjar.weixin.cp.util.json.WxCpGsonBuilder;

/**
 * <pre>
 * 外部联系人详情
 * Created by Binary Wang on 2018/9/16.
 * 参考文档：https://work.weixin.qq.com/api/doc#13878
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Getter
@Setter
public class WxCpUserExternalContactInfo {
  @SerializedName("external_contact")
  private ExternalContact externalContact;

  @SerializedName("follow_user")
  private List<FollowedUser> followedUsers;

  @Getter
  @Setter
  public static class ExternalContact {
    @SerializedName("external_userid")
    private String externalUserId;

    @SerializedName("position")
    private String position;

    @SerializedName("name")
    private String name;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("corp_name")
    private String corpName;

    @SerializedName("corp_full_name")
    private String corpFullName;

    @SerializedName("type")
    private Integer type;

    @SerializedName("gender")
    private Integer gender;

    @SerializedName("unionid")
    private String unionId;

    @SerializedName("external_profile")
    private ExternalProfile externalProfile;
  }

  @Setter
  @Getter
  public static class ExternalProfile {
    @SerializedName("external_attr")
    private List<ExternalAttribute> externalAttrs;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ExternalAttribute {
    @Setter
    @Getter
    public static class Text {
      private String value;
    }

    @Setter
    @Getter
    public static class Web {
      private String title;
      private String url;
    }

    @Setter
    @Getter
    public static class MiniProgram {
      @SerializedName("pagepath")
      private String pagePath;
      private String appid;
      private String title;
    }

    private int type;

    private String name;

    private Text text;

    private Web web;

    @SerializedName("miniprogram")
    private MiniProgram miniProgram;
  }

  @Setter
  @Getter
  public static class FollowedUser {
    @SerializedName("userid")
    private String userId;
    private String remark;
    private String description;
    @SerializedName("createtime")
    private Long createTime;
  }

  public static WxCpUserExternalContactInfo fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpUserExternalContactInfo.class);
  }
}
