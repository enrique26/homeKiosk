/* C++ code produced by gperf version 3.0.3 */
/* Command-line: /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/gperf -L C++ -E -t /Users/addieljuarez/Documents/Appcelerator_Studio_Workspace/booterone/android/build/generated/KrollGeneratedBindings.gperf  */
/* Computed positions: -k'' */

#line 3 "/Users/addieljuarez/Documents/Appcelerator_Studio_Workspace/booterone/android/build/generated/KrollGeneratedBindings.gperf"


#include <string.h>
#include <v8.h>
#include <KrollBindings.h>

#include "com.ibilis.booterone.ExampleProxy.h"
#include "com.ibilis.booterone.BooteroneModule.h"


namespace titanium {
namespace bindings {
#line 16 "/Users/addieljuarez/Documents/Appcelerator_Studio_Workspace/booterone/android/build/generated/KrollGeneratedBindings.gperf"
struct BindEntry;
/* maximum key range = 4, duplicates = 0 */

class BooteroneBindings
{
private:
  static inline unsigned int hash (const char *str, unsigned int len);
public:
  static struct BindEntry *lookupGeneratedInit (const char *str, unsigned int len);
};

inline /*ARGSUSED*/
unsigned int
BooteroneBindings::hash (register const char *str, register unsigned int len)
{
  return len;
}

struct BindEntry *
BooteroneBindings::lookupGeneratedInit (register const char *str, register unsigned int len)
{
  enum
    {
      TOTAL_KEYWORDS = 2,
      MIN_WORD_LENGTH = 33,
      MAX_WORD_LENGTH = 36,
      MIN_HASH_VALUE = 33,
      MAX_HASH_VALUE = 36
    };

  static struct BindEntry wordlist[] =
    {
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""},
#line 19 "/Users/addieljuarez/Documents/Appcelerator_Studio_Workspace/booterone/android/build/generated/KrollGeneratedBindings.gperf"
      {"com.ibilis.booterone.ExampleProxy",::com::ibilis::booterone::booterone::ExampleProxy::bindProxy,::com::ibilis::booterone::booterone::ExampleProxy::dispose},
      {""}, {""},
#line 18 "/Users/addieljuarez/Documents/Appcelerator_Studio_Workspace/booterone/android/build/generated/KrollGeneratedBindings.gperf"
      {"com.ibilis.booterone.BooteroneModule",::com::ibilis::booterone::BooteroneModule::bindProxy,::com::ibilis::booterone::BooteroneModule::dispose}
    };

  if (len <= MAX_WORD_LENGTH && len >= MIN_WORD_LENGTH)
    {
      unsigned int key = hash (str, len);

      if (key <= MAX_HASH_VALUE)
        {
          register const char *s = wordlist[key].name;

          if (*str == *s && !strcmp (str + 1, s + 1))
            return &wordlist[key];
        }
    }
  return 0;
}
#line 20 "/Users/addieljuarez/Documents/Appcelerator_Studio_Workspace/booterone/android/build/generated/KrollGeneratedBindings.gperf"

}
}
